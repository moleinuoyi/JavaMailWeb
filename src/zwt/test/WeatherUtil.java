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
		private static final String SERVICES_HOST = "www.webxml.com.cn";// 主机
		//private static final String WEATHER_SERVICES_URL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/";
		private static final String WEATHER_SERVICES_URL = "http://wthrcdn.etouch.cn/";//http://wthrcdn.etouch.cn/WeatherApi?city=北京
		// 获取天气																	getWeather?theCityCode=&theUserID=
		private static final String WEATHER_QUERY_URL = WEATHER_SERVICES_URL	+ "WeatherApi?city=";//"weather_mini?city=";
		private static final String WEATHER_QUERY_URL_JSON = WEATHER_SERVICES_URL	+ "weather_mini?city=";
	 /****
	  * http://wthrcdn.etouch.cn/weather_mini?city=
	  * @param cityCode
	  * @return
	 
		public static List<String> getWeathers(String cityCode) {
			//定义一个集合装载添加数据
			List<String> weatherList = new ArrayList<String>();
			//获取xml文档对象
			Document document;
			//获取解析工厂
			DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
			//设定命名空间
			documentBF.setNamespaceAware(true);
			try {
				//初始xml工厂
				DocumentBuilder db = documentBF.newDocumentBuilder();
				//获取天气数据接口返回的数据
				//URL urlObj = new URL(WEATHER_QUERY_URL+ cityCode);
				URL urlObj = new URL(WEATHER_QUERY_URL+ cityCode);
				// 打开连接
				URLConnection urlConn = urlObj.openConnection(); 
				// 通过地址访问主机,设置请求代理
				//urlConn.setRequestProperty("Host", SERVICES_HOST);
				//开始连接
				urlConn.connect();
				//读取
				InputStream inputStream = urlConn.getInputStream();
				//开始解析
				
				byte b[] = new byte[1024];        // 所有的内容都读到此数组之中
				inputStream.read(b);        // 读取内容   网络编程中 read 方法会阻塞
				System.out.println("内容为：" + convertStreamToString(inputStream));
				
//				document = db.parse(inputStream);
//				//解析string节点
//				NodeList nl = document.getElementsByTagName("string");
//				System.out.println(nl);
//				int len = nl.getLength();
//				for (int i = 0; i < len; i++) {
//					Node n =  nl.item(i);//获取每一个string节点     
//					//n.getFirstChild()获取文本节点
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
			//1665湖南 益阳, 安化
			//101030700
			//List<String> strings = TmWeatherUtil.getWeathers("深圳");
			String str = getWeatherInfo(WEATHER_QUERY_URL_JSON+"深圳");
			System.out.println(str);
//			JSONObject json = JSONObject.fromObject(str);
//			SAXReader reader = new SAXReader(); //1.创建一个xml解析器对象
//
//			Document doc = reader.read("<A><city>123</city></A>");//2.读取xml文档，返回Document对象
//			
//			Element elem =  doc.getRootElement();
//			System.out.println(elem.elementText("city"));
//			Element e =  elem.element("forecast");
					
			//www.webxml.com.cn
		}
		public void tianqi() {
			//{"data":{"yesterday":{"date":"10日星期日","high":"高温 18℃","fx":"无持续风向","low":"低温 15℃","fl":"<![CDATA[<3级]]>","type":"中雨"},"city":"深圳","forecast":[{"date":"11日星期一","high":"高温 21℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"无持续风向","type":"多云"},{"date":"12日星期二","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"无持续风向","type":"晴"},{"date":"13日星期三","high":"高温 23℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"无持续风向","type":"阵雨"},{"date":"14日星期四","high":"高温 22℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"无持续风向","type":"中雨"},{"date":"15日星期五","high":"高温 21℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"无持续风向","type":"小雨"}],"ganmao":"天气转凉，空气湿度较大，较易发生感冒，体质较弱的朋友请注意适当防护。","wendu":"18"},"status":1000,"desc":"OK"}
		}
		

}
