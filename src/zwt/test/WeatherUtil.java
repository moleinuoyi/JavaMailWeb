package zwt.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class WeatherUtil {
	// private static final long serialVersionUID = 1L;
		private static final String SERVICES_HOST = "www.webxml.com.cn";// ����
		private static final String WEATHER_SERVICES_URL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/";
		// ��ȡ����																	getWeather?theCityCode=&theUserID=
		private static final String WEATHER_QUERY_URL = WEATHER_SERVICES_URL	+ "getWeather?theUserID=&theCityCode=";
	 
	 
		public static List<String> getWeathers(int cityCode) {
			//����һ������װ���������
			List<String> weatherList = new ArrayList<String>();
			/*��ȡxml�ĵ�����*/
			Document document;
			/*��ȡ��������*/
			DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
			//�趨�����ռ�
			documentBF.setNamespaceAware(true);
			try {
				//��ʼxml����
				DocumentBuilder db = documentBF.newDocumentBuilder();
				//��ȡ�������ݽӿڷ��ص�����
				URL urlObj = new URL(WEATHER_QUERY_URL+ cityCode);
				// ������
				URLConnection urlConn = urlObj.openConnection(); 
				// ͨ����ַ��������,�����������
				urlConn.setRequestProperty("Host", SERVICES_HOST);
				//��ʼ����
				urlConn.connect();
				//��ȡ
				InputStream inputStream = urlConn.getInputStream();
				//��ʼ����
				document = db.parse(inputStream);
				//����string�ڵ�
				NodeList nl = document.getElementsByTagName("string");
				System.out.println(nl);
				int len = nl.getLength();
				for (int i = 0; i < len; i++) {
					Node n =  nl.item(i);//��ȡÿһ��string�ڵ�     
					//n.getFirstChild()��ȡ�ı��ڵ�
					String weather = n.getFirstChild().getNodeValue();
					weatherList.add(weather);
				}
				inputStream.close();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return weatherList;
		}
		public static void main(String[] args) {
			WeatherUtil TmWeatherUtil = new WeatherUtil();
			//1665���� ����, ����
			//101030700
			List<String> strings = TmWeatherUtil.getWeathers(1868);
			System.out.println(strings);
			//www.webxml.com.cn
		}

}
