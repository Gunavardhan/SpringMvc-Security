package com.access.denied;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyAccessDeniedHandler implements AccessDeniedHandler{

	private String errorPage;
	
	public MyAccessDeniedHandler(){
	}
	
	public MyAccessDeniedHandler(String errorPage){
		this.errorPage = errorPage;
	}
	
	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		/*if(errorPage != null && !errorPage.startsWith("/")){
			throw new IllegalArgumentException("Error page must begin with '/' ");
		}*/
		this.errorPage = errorPage;
	}

	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
			throws IOException, ServletException {
		if(!response.isCommitted()){
			if(errorPage != null){
				request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
				response.setStatus(HttpStatus.FORBIDDEN.value());
				RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
				dispatcher.forward(request, response);
			}
		}else{
			response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
		}
		response.sendRedirect(errorPage);
	}

}
