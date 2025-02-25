import java.util.ArrayList;
import java.util.List;

/*
Proxy pattern is used to provide a surrogate or placeholder object, which references an underlying object.
The proxy object controls access to the real object, allowing you to perform something either before or after
the request gets through to the real object.
*/

interface Internet {
    void connectTo(String url);
}

class RealInternet implements Internet {
    @Override
    public void connectTo(String url) {
        System.out.println("Connecting to " + url);
    }
}

class ProxyInternet implements Internet {
    private RealInternet realInternet = new RealInternet();
    private static List<String> bannedSites = new ArrayList<>();

    static {
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lmn.com");
    }

    @Override
    public void connectTo(String url) {
        if (bannedSites.contains(url)) {
            System.out.println("Access Denied");
            return;
        }
        realInternet.connectTo(url);
    }
}
public class Proxy {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connectTo("abc.com");
        internet.connectTo("google.com");
    }
}
