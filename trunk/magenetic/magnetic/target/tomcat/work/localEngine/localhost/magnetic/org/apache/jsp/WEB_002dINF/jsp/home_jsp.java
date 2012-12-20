package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<!--");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("-->\n");
      out.write("\t<title>Home</title>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.8.3.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t/*\n");
      out.write("\t\tfunction send() {\n");
      out.write("\t\t\t  $.ajax({\n");
      out.write("\t\t            url: \"/magnetic/send\",\n");
      out.write("\t\t            data: ({sendMsg:$(\"#sendMsg\").val()}),\n");
      out.write("\t\t            success: function(data) {\n");
      out.write("\t\t                $(\"#sendMsg\").val(\"\");\n");
      out.write("\t\t                $(\"#viewMsg\").append(\"님의 말 : \");\n");
      out.write("\t\t                $(\"#viewMsg\").append(\"<br>\");\n");
      out.write("\t\t                $(\"#viewMsg\").append(\"·\"+ data);\n");
      out.write("\t\t                $(\"#viewMsg\").append(\"<br>\");\n");
      out.write("\t\t                $(\"#viewMsg\").scrollTop(parseInt(document.body.scrollHeight));\n");
      out.write("\t\t            }\n");
      out.write("\t\t        });\n");
      out.write("\t\t}\n");
      out.write("\t*/\n");
      out.write("\t\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t//DWR Reverse Ajax 활성화\n");
      out.write("\t    dwr.engine.setActiveReverseAjax(true);\n");
      out.write("\t\t$(\"#sendMsg\").focus();\n");
      out.write("\t\t\n");
      out.write("\t\tMainController.connect({},\n");
      out.write("\t\t\t\tfunction(data) {\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\tvar loginName = \"\";\n");
      out.write("\t\n");
      out.write("\tfunction receive(mainVo) {\n");
      out.write("\t\tif(loginName != mainVo.name) {\n");
      out.write("          $(\"#viewMsg\").append(mainVo.name + \" 님의 말 : \");\n");
      out.write("          $(\"#viewMsg\").append(\"\\r\\n\");\n");
      out.write("\t\t}\n");
      out.write("\t\tloginName = mainVo.name;\n");
      out.write("          $(\"#viewMsg\").append(\"· \"+ mainVo.content);\n");
      out.write("          $(\"#viewMsg\").append(\"\\r\\n\");\n");
      out.write("          $('#viewMsg').scrollTop($('#viewMsg')[0].scrollHeight);\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction send() {\n");
      out.write("\t\tvar str = $(\"#sendMsg\").val();\n");
      out.write("\t\tstr = str.replace(/[\\r|\\n]/g, '');\n");
      out.write("\t\tif(str == \"\") {\n");
      out.write("\t\t\t $(\"#sendMsg\").val(\"\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\tMainController.sendMessage({content:str},\n");
      out.write("\t\t\tfunction(data) {\n");
      out.write("\t\t\t$(\"#sendMsg\").val(\"\");\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction logOut() {\n");
      out.write("\t\t   $(\"#logoutForm\").submit();\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction connect(mainVo) {\n");
      out.write("\t\t$(\"#viewMsg\").append(mainVo.name + \" 님이 접속 하였습니다.\");\n");
      out.write("\t\t$(\"#viewMsg\").append(\"\\r\\n\");\n");
      out.write("\t}\n");
      out.write("\t    \n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("ul{\n");
      out.write("   list-style:none;\n");
      out.write("   }\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<form id=\"logoutForm\" action=\"/magnetic/logout\">\n");
      out.write("\t</form>\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li>\n");
      out.write("\t\t\t<textarea rows=\"20\" cols=\"50\" id=\"viewMsg\" readonly=\"readonly\"></textarea>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li>\n");
      out.write("\t\t\t<textarea rows=\"2\" cols=\"50\" id=\"sendMsg\"  onKeypress=\"if(event.keyCode==13){send();}\"></textarea>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t\n");
      out.write("\t</ul>\n");
      out.write("\t\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li>\n");
      out.write("\t\t\t<input type=\"button\" value=\"logout\" onclick=\"logOut();\"/>\n");
      out.write("\t\t</li>\n");
      out.write("\t</ul>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fimport_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /WEB-INF/jsp/home.jsp(7,4) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fimport_005f0.setUrl("/WEB-INF/jsp/common/common.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
      if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/jsp/home.jsp(9,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/dwr/engine.js");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/jsp/home.jsp(10,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/dwr/util.js");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /WEB-INF/jsp/home.jsp(11,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/dwr/interface/MainController.js");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }
}
