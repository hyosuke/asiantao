package jp.ne.asiantao.util;

import java.io.IOException;
import java.lang.annotation.Annotation;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.ne.asiantao.dto.UserDto;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ForwardConfig;
import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.factory.BeanDescFactory;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.struts.action.S2RequestProcessor;
import org.seasar.struts.config.S2ActionMapping;
import org.seasar.struts.config.S2ExecuteConfig;
import org.seasar.struts.util.S2ExecuteConfigUtil;



public class AuthRequestProcessor extends S2RequestProcessor{
	
    @Resource
    protected UserDto userDto;

	@Override
	protected boolean processRoles(HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws IOException, ServletException {
		
		
		S2ExecuteConfig executeConfig = S2ExecuteConfigUtil.getExecuteConfig();
		
		//実行メソッドのアノテーションを取得
		Annotation [] anotations = executeConfig.getMethod().getAnnotations();
		
		for(Annotation annotation : anotations){
			
			if(annotation.annotationType().getName().equals("jp.ne.asiantao.util.Auth")){//Authアノテーションが付属されている場合
				
/*				
				Map<String, Object> sessionScope = SingletonS2Container.getComponent("sessionScope");
				
				UserDto userDto = (UserDto)sessionScope.get("userDto");*/
/*				
				HttpSession session = RequestUtil.getRequest().getSession();
				userDto = (UserDto) HotdeployUtil.rebuildValue(session.getAttribute("userDto"));
				*/
				//ログイン情報を取得
				Object obj = SingletonS2Container.getComponent(UserDto.class);
				BeanDesc beanDesc = BeanDescFactory.getBeanDesc(obj.getClass());
				Boolean isLogin = (Boolean) beanDesc.invoke(obj,"isLogin",null);
				
				if(!isLogin){//ログイン情報がない場合
					
				//ログイン画面にフォワード
				 ForwardConfig forward =  new S2ActionMapping().createForward("/login", true);
				 super.processForwardConfig(request, response, forward);
				 
				 return false;
				}
			}
		}
		
		
		
		return super.processRoles(request, response, mapping);
		
		
		
	} 
	

}
