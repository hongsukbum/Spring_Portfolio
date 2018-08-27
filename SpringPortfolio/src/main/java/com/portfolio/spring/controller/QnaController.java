package com.portfolio.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.spring.dao.QnaDao;
import com.portfolio.spring.dto.QnaDto;

@Controller
public class QnaController {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/qnalist")
	public String qnaList(Model model) {
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
				
		model.addAttribute("viewQnalist",dao.viewQnalist());
		
		return "/qna/qnaList";
		
	}
	
	@RequestMapping("/qnaView")
	public String qnaView(Model model, HttpServletRequest req) {
		
		int qna_idx = Integer.parseInt(req.getParameter("qna_idx"));
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		
		model.addAttribute("viewQnaDetail", dao.viewQnaDetail(qna_idx));
		
		return "/qna/qnaView";
	}
	
	@RequestMapping("/qnaWrite")
	public String qnaWrite(HttpServletRequest req, Model model) {
		
		System.out.println("qna_write()");
		
		int qna_idx = 0;
		
		String strQnaIdx = req.getParameter("qna_idx");
		
		if(strQnaIdx != null) {
			qna_idx = Integer.parseInt(strQnaIdx);
			model.addAttribute("qna_idx", qna_idx);
		}
		
		String qna_title = req.getParameter("qna_title");
		String qna_content = req.getParameter("qna_content");
		
		model.addAttribute("qna_title", qna_title);
		model.addAttribute("qna_content", qna_content);
		
		
		return "/qna/qnaWrite";
	}
	
	
	@RequestMapping("/qnaWriteConfirm")
	public String qnaWriteConfirm(HttpServletRequest req, Model model) {
		
		String qna_title = req.getParameter("qna_title");
		String qna_content = req.getParameter("qna_content");
		
		System.out.println(" qna write confirm title :: " + qna_title + " / content :: " + qna_content);
		
		HttpSession session = req.getSession();
		String qna_unick = (String) session.getAttribute("unick");
		int qna_qnac_idx = 0;
		int qna_pd_idx = 0;
		int qna_state = 0;
		
		QnaDto dto = new QnaDto(qna_unick, qna_qnac_idx, qna_pd_idx, qna_state, qna_title, qna_content);
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.insertQna(dto);
		
		return "redirect:/qnalist";
	}
	
	@RequestMapping("/qnaModifyConfirm")
	public String qnaModifyConfirm(HttpServletRequest req, Model model) {
		
		int qna_idx = Integer.parseInt(req.getParameter("qna_idx")); 
		
		System.out.println("qna Modify confirm idx :: " + qna_idx);
		
		String qna_title = req.getParameter("qna_title");
		String qna_content = req.getParameter("qna_content");
		
		HttpSession session = req.getSession();
		
		String qna_unick = (String) session.getAttribute("unick");
		int qna_qnac_idx = 0;
		int qna_pd_idx = 0;
		int qna_state = 0;
				
		QnaDto dto = new QnaDto(qna_unick, qna_qnac_idx, qna_pd_idx, qna_state, qna_title, qna_content);
		
		dto.setQna_idx(qna_idx);
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.updateQna(dto);
		
		return "redirect:/qnalist";
	}
}
