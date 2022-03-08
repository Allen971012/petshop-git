package home.petshop.gateway.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public MyAuthenticationSuccessHandler(String defaultUrl){
        setDefaultTargetUrl(defaultUrl);
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session!=null){
            String url = (String)session.getAttribute("preLogin");
            log.debug("securityUrl:{}",url);
            if(url!=null){
                session.removeAttribute("isLogin");
                getRedirectStrategy().sendRedirect(request,response,url);
                log.debug("成功轉發url:{}",url);
                return;
            }else{
                super.onAuthenticationSuccess(request,response,authentication);
                log.debug("轉發失敗");
                return;
            }
        }
        super.onAuthenticationSuccess(request,response,authentication);
    }
}
