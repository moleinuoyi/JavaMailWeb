package zwt.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;



public class WeatherUtil {
	// private static final long serialVersionUID = 1L;
		private static final String SERVICES_HOST = "www.webxml.com.cn";// ����
		//private static final String WEATHER_SERVICES_URL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/";
		private static final String WEATHER_SERVICES_URL = "http://wthrcdn.etouch.cn/";//http://wthrcdn.etouch.cn/WeatherApi?city=����
		// ��ȡ����																	getWeather?theCityCode=&theUserID=
		private static final String WEATHER_QUERY_URL = WEATHER_SERVICES_URL	+ "WeatherApi?city=";//"weather_mini?city=";
		private static final String WEATHER_QUERY_URL_JSON = WEATHER_SERVICES_URL	+ "weather_mini?city=";
	 /****
	  * http://wthrcdn.etouch.cn/weather_mini?city=
	  * @param cityCode
	  * @return
	 
		public static List<String> getWeathers(String cityCode) {
			//����һ������װ���������
			List<String> weatherList = new ArrayList<String>();
			//��ȡxml�ĵ�����
			Document document;
			//��ȡ��������
			DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
			//�趨�����ռ�
			documentBF.setNamespaceAware(true);
			try {
				//��ʼxml����
				DocumentBuilder db = documentBF.newDocumentBuilder();
				//��ȡ�������ݽӿڷ��ص�����
				//URL urlObj = new URL(WEATHER_QUERY_URL+ cityCode);
				URL urlObj = new URL(WEATHER_QUERY_URL+ cityCode);
				// ������
				URLConnection urlConn = urlObj.openConnection(); 
				// ͨ����ַ��������,�����������
				//urlConn.setRequestProperty("Host", SERVICES_HOST);
				//��ʼ����
				urlConn.connect();
				//��ȡ
				InputStream inputStream = urlConn.getInputStream();
				//��ʼ����
				
				byte b[] = new byte[1024];        // ���е����ݶ�����������֮��
				inputStream.read(b);        // ��ȡ����   �������� read ����������
				System.out.println("����Ϊ��" + convertStreamToString(inputStream));
				
//				document = db.parse(inputStream);
//				//����string�ڵ�
//				NodeList nl = document.getElementsByTagName("string");
//				System.out.println(nl);
//				int len = nl.getLength();
//				for (int i = 0; i < len; i++) {
//					Node n =  nl.item(i);//��ȡÿһ��string�ڵ�     
//					//n.getFirstChild()��ȡ�ı��ڵ�
//					String weather = n.getFirstChild().getNodeValue();
//					weatherList.add(weather);
//				}
				inputStream.close();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
//			} catch (SAXException e) {
//				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return weatherList;
		}
*/
		public static String getWeatherInfo(String url) {  
		       CloseableHttpClient client;  
		       client = HttpClients.createDefault();  

		       HttpGet get = new HttpGet(url);  
		       HttpResponse response;  
		       try {  
		           response = client.execute(get);  
		           HttpEntity entity = response.getEntity();  
		           if (entity != null) {  
		               InputStream instreams = entity.getContent();  
		               String str = WeatherUtil.convertStreamToString(instreams);  
		               get.abort();  
		               return str;  
		           }  
		       } catch (IOException e) {  
		           e.printStackTrace();  
		       }  
		       return null;  
		   }
		private static String convertStreamToString(InputStream is) {  
		       StringBuilder sb1 = new StringBuilder();  
		       byte[] bytes = new byte[4096];  
		       int size;  

		       try {  
		           while ((size = is.read(bytes)) > 0) {  
		               String str = new String(bytes, 0, size, "UTF-8");  
		               sb1.append(str);  
		           }  
		       } catch (IOException e) {  
		           e.printStackTrace();  
		       } finally {  
		           try {  
		               is.close();  
		           } catch (IOException e) {  
		               e.printStackTrace();  
		           }  
		       }  
		       return sb1.toString();  
		   }  

		
		public static void main(String[] args){
			WeatherUtil TmWeatherUtil = new WeatherUtil();
			//1665���� ����, ����
			//101030700
			//List<String> strings = TmWeatherUtil.getWeathers("����");
			String str = getWeatherInfo(WEATHER_QUERY_URL_JSON+"����");
			System.out.println(str);
//			JSONObject json = JSONObject.fromObject(str);
//			SAXReader reader = new SAXReader(); //1.����һ��xml����������
//
//			Document doc = reader.read("<A><city>123</city></A>");//2.��ȡxml�ĵ�������Document����
//			
//			Element elem =  doc.getRootElement();
//			System.out.println(elem.elementText("city"));
//			Element e =  elem.element("forecast");
					
			//www.webxml.com.cn
		}
		public void tianqi() {
			//{"data":{"yesterday":{"date":"10��������","high":"���� 18��","fx":"�޳�������","low":"���� 15��","fl":"<![CDATA[<3��]]>","type":"����"},"city":"����","forecast":[{"date":"11������һ","high":"���� 21��","fengli":"<![CDATA[<3��]]>","low":"���� 16��","fengxiang":"�޳�������","type":"����"},{"date":"12�����ڶ�","high":"���� 25��","fengli":"<![CDATA[<3��]]>","low":"���� 16��","fengxiang":"�޳�������","type":"��"},{"date":"13��������","high":"���� 23��","fengli":"<![CDATA[<3��]]>","low":"���� 16��","fengxiang":"�޳�������","type":"����"},{"date":"14��������","high":"���� 22��","fengli":"<![CDATA[<3��]]>","low":"���� 16��","fengxiang":"�޳�������","type":"����"},{"date":"15��������","high":"���� 21��","fengli":"<![CDATA[<3��]]>","low":"���� 17��","fengxiang":"�޳�������","type":"С��"}],"ganmao":"����ת��������ʪ�Ƚϴ󣬽��׷�����ð�����ʽ�����������ע���ʵ�������","wendu":"18"},"status":1000,"desc":"OK"}
		}
		

}
