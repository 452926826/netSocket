package hand;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonObject;


public class Main {
	public static void main(String[] args) {
		//System.out.println("123");
		new Get().start();
	}
	}
class Get extends Thread
{
	HttpClient client=HttpClients.createDefault();

	public void run() {
		HttpGet get=new HttpGet("http://hq.sinajs.cn/list=sz300170");
		try {
			
			
			HttpResponse response=client.execute(get);
			HttpEntity entity=response.getEntity();
			String s=EntityUtils.toString(entity,"utf-8");
			//System.out.println(s);
			
			
			String []str=s.split("=")[1].replaceAll("\"", "").replaceAll(";", "").split(",");
		
			
			
			
			//生成xml
			try {
				DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
				DocumentBuilder db=factory.newDocumentBuilder();
				
				Document d=db.newDocument();
				
				Element root=d.createElement("stock");
				Element name=d.createElement("name");
				name.setTextContent(str[0]);
				
				
				Element open=d.createElement("open");
				open.setTextContent(str[1]);
				
				Element close=d.createElement("close");
				close.setTextContent(str[2]);
				
				Element current=d.createElement("current");
				current.setTextContent(str[3]);
				
				Element high=d.createElement("high");
				high.setTextContent(str[4]);
				
				Element low=d.createElement("low");
				low.setTextContent(str[5]);
				root.appendChild(name);
				root.appendChild(open);
				root.appendChild(close);
				root.appendChild(current);
				root.appendChild(high);
				root.appendChild(low);
				
				for (int i=6;i<str.length;i++) {
					
					Element data=d.createElement("data"+i);
					data.setTextContent(str[i]);
					root.appendChild(data);
				}
				
				d.appendChild(root);
				
				TransformerFactory tff=TransformerFactory.newInstance();
				Transformer tf=tff.newTransformer();
				StringWriter w=new StringWriter();
				tf.transform(new DOMSource(d), new StreamResult(w));
				System.out.println(w.toString());
				
				
				tf.transform(new DOMSource(d), new StreamResult(new File("new.xml")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//生成json文件
			JsonObject object=new JsonObject();
			object.addProperty("name", str[0]);
			object.addProperty("open", str[1]);
			object.addProperty("close", str[2]);
			object.addProperty("current", str[3]);
			object.addProperty("hight", str[4]);
			object.addProperty("low", str[5]);
			for (int i=6;i<str.length;i++) {
				
				object.addProperty("data"+i, str[i]);
			}
			System.out.println(object.toString());
			FileOutputStream fos=new FileOutputStream(new File("json.json"));
			fos.write(object.toString().getBytes());
			fos.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
