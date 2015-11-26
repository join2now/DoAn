import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.processing.Messager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class R_GetData {
	public static void Geta(String _url, String _pathsave)
	{
		String _link=_url;
		String _path=_pathsave;
		PrintWriter _writer;
		
		try {
			_writer= new PrintWriter(_path,"utf-8");
			Document _doc=Jsoup.connect(_link).get();
			
			//LAY TAT CA: UL
			Elements _ul=_doc.select("ul.nav.nav-list.primary.left-menu");
			
			Elements _lista;
			for(Element _subul: _ul)
			{
				_lista=_subul.select("a");
				System.out.println(_lista);
				_writer.println(_lista);
			}
			_writer.close();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void LayHref(String _url, String _pathsave){
		String _link=_url;
		String _path=_pathsave;
		PrintWriter _writer;
		
		try {
			_writer= new PrintWriter(_path,"utf-8");
			Document _doc=Jsoup.connect(_link).get();
			//String _host=_doc.baseUri();
			//System.out.println(_host);
			//LAY TAT CA: UL
			Elements _ul=_doc.select("ul.nav.nav-list.primary.left-menu");
			
			Elements _lista;
			Elements _href;
			for(Element _subul: _ul)
			{
				_lista=_subul.select("a");
				for(Element _subhref: _lista)
				{
					_href=_subhref.getElementsByAttribute("href");
					String _tmphref=_href.attr("href");
					String _content=_href.text();
					String _valHref=_tmphref.substring(_tmphref.indexOf("/"));
					
					System.out.println(_valHref);
					System.out.println(_content);
					_writer.println("http://vietjack.com"+_valHref+" --> "+_content);
				}
				
			}
			_writer.close();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//LAY NOI DUNG TUNG HREF
	public static void getContent(String _Href, String _pathsave)
	{
		String _link=_Href;
		String _path=_pathsave;
		PrintWriter _writer;
		
		try {
			_writer= new PrintWriter(_path,"utf-8");
			Document _doc=Jsoup.connect(_link).get();
			Elements _tagP=_doc.getElementsByTag("p");
			_writer.println(_tagP);
			System.out.println(_tagP);
			_writer.close();
			System.out.println("DONE!");
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	//
	public static void _getLink(String _Href, String _pathsave){
		Document _doc;
		String _link=_Href;
		String _path=_pathsave;
		PrintWriter _writer;
		try
		{
			_writer=new PrintWriter(_path,"utf-8");
			_doc=Jsoup.connect(_link).get();
			Elements _links=_doc.select("a");
			for( Element link:_links )
			{
				//get the value from href attribute
				_writer.println(link);
				System.out.println(link);
			}
			_writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String _link = "http://vietjack.com/java/hoc_java_co_ban.jsp";
		//String _pathSave="D:\\Subject\\HOC KY 2 CAO HOC\\Mon Cong Nghe Moi\\Do An\\result_links.txt";
		//String _pathSave="D:\\Subject\\HOC KY 2 CAO HOC\\Mon Cong Nghe Moi\\Do An\\result_linka.txt";
		
		//String _pathHref="D:\\Subject\\HOC KY 2 CAO HOC\\Mon Cong Nghe Moi\\Do An\\result_href.txt";
		
		//Geta(_link, _pathSave);
		
		//LayHref(_link, _pathHref);
		//String _href="http://vietjack.com/java/index.jsp";
		//String _path="D:\\Subject\\HOC KY 2 CAO HOC\\Mon Cong Nghe Moi\\Do An\\result_contents.txt";
		//getContent(_href, _path);
		
		_getLink(_href, _path);
	}
	

}
