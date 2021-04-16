package geoisp;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.model.CityResponse;
import java.net.Inet4Address;
import java.net.InetAddress;

public class Main {
  private static int MAX_MIND_USER = 89293;
  private static String MAX_MIND_LICENSE = "fZ0WHEC3fDoa";
  
  public static void main(String[] args) {
      String strAddr = args[0];
      String host = "geoip.maxmind.com";
      if (args.length > 1) { host = args[1]; }
      WebServiceClient client = new WebServiceClient.Builder(
          MAX_MIND_USER, MAX_MIND_LICENSE
      ).host(host).build();
      try {
          InetAddress addr = Inet4Address.getByName(strAddr);
          CityResponse cityResponse = client.city(addr);
          System.out.println(cityResponse);
      } catch(Throwable e) {
          System.out.println(e);
      }
  }
}