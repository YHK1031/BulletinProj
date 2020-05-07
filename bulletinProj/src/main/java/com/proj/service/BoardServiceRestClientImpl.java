package com.proj.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proj.bindingEntity.BoardArticle;
import com.proj.entity.Board;

@Service
public class BoardServiceRestClientImpl implements BoardService {

	private RestTemplate restTemplate;
	private String restUrl;	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public BoardServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		restUrl = theUrl+"/article";
				
		logger.info("Loaded property:  rest.url=" + restUrl);
	}
	
	
	@Override
	public List<Board> getBoards() {
		logger.info("in getUsers(): Calling REST API " + restUrl);

		// make REST call
		ResponseEntity<List<Board>> responseEntity = 
											restTemplate.exchange(restUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Board>>() {});

		// get the list of customers from response
		List<Board> boards = responseEntity.getBody();

		logger.info("in getBoards(): boards" + boards);
		
		return boards;
	}

	@Override
	public Board getBoard(Long theId) {
		logger.info("in getUser(): Calling REST API " + restUrl);

		// make REST call
		Board theBoard = 
				restTemplate.getForObject(restUrl + "/" + theId, 
						Board.class);

		logger.info("in getBoard(): theBoard=" + theBoard);
		
		return theBoard;
	}

	@Override
	public void saveBoard(BoardArticle boardArticle) {
		
		logger.info("in saveUser(): Calling REST API " + restUrl);
		
		// make REST call
		restTemplate.postForEntity(restUrl, boardArticle, String.class);	
		

		logger.info("in saveBoard(): success");	
	}

	@Override
	public void deleteBoard(Long theId) {
		logger.info("in deleteBoard(): Calling REST API " + restUrl);

		// make REST call
		restTemplate.delete(restUrl + "/" + theId);

		logger.info("in deleteBoard(): deleted board theId=" + theId);
	}

	@Override
	public void likeBoard(Long theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dislikeBoard(Long theId) {
		// TODO Auto-generated method stub

	}

}
