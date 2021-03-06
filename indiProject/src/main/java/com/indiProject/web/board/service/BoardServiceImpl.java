package com.indiProject.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indiProject.web.board.dao.BoardDAO;
import com.indiProject.web.board.model.BoardVO;
import com.indiProject.web.board.model.ReplyVO;
import com.indiProject.web.common.Pagination;
import com.indiProject.web.common.Search;
import com.indiProject.web.error.controller.NotFoundException;

@Service

public class BoardServiceImpl implements BoardService {

	@Inject

	private BoardDAO boardDAO;

	public List<BoardVO> getBoardList(Search search) throws Exception {

		return boardDAO.getBoardList(search);

	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}

	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		boardDAO.updateViewCnt(bid);

		BoardVO boardVO = new BoardVO();

		boardVO = boardDAO.getBoardContent(bid);

		return boardVO;
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}

	@Override

	public void deleteBoard(int bid) throws Exception {

		boardDAO.deleteBoard(bid);

	}

	@Override

	public int getBoardListCnt(Search search) throws Exception {

		return boardDAO.getBoardListCnt(search);

	}

	// 댓글 리스트

	@Override

	public List<ReplyVO> getReplyList(int bid) throws Exception {

		return boardDAO.getReplyList(bid);

	}

	@Override

	public int saveReply(ReplyVO replyVO) throws Exception {

		return boardDAO.saveReply(replyVO);

	}

	@Override

	public int updateReply(ReplyVO replyVO) throws Exception {

		return boardDAO.updateReply(replyVO);

	}

	@Override

	public int deleteReply(int rid) throws Exception {

		return boardDAO.deleteReply(rid);

	}

}
