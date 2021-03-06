package service;

import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.SetCommaTS;
import util.View;
import dao.BoardDao;
import dao.NoticeDao;

public class BoardService {
	
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	private SetCommaTS setc = SetCommaTS.getInstance();
	private BoardDao boardDao = BoardDao.getInstance();
	private NoticeDao noticeDao = NoticeDao.getInstance();
	public int boardList(){
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		System.out.print("===========================");
		if(noticeDao.selectnoticenoread().size()>0){
			System.out.println(("π(+"+noticeDao.selectnoticenoread().size()+")======="));
		} else{System.out.println("=============");
		}
		System.out.println("=======================================");
		System.out.println("-------------μ€λμ ν«λ!-------------");
		System.out.println("μ ν                                                   κ°κ²©");
		System.out.println("----------------------------------------");
		
		for(Map<String, Object> board : boardList){
			System.out.println(board.get("PROD_NAME"));
			System.out.println("                          "+setc.Setcomma(board.get("PROD_SALE").toString()));
		} 
		
		System.out.println("=======================================");
		System.out.println("1.μνμ‘°ν \t 2.μΉ΄νΈμ‘°ν \t 3.λ΄μ λ³΄ \t 0.λ‘κ·Έμμ");
		System.out.print("μλ ₯>");
		
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			return View.SEARCHPROD;
		case 2:
			return View.CARTLIST;			
		case 3:
			return View.USERINFO;			
		case 0:
			return View.HOME;
			
		}
		return View.MAIN;
	}
	
}









