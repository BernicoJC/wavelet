import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler{
    ArrayList<String> dataList= new ArrayList<>();

    public String handleRequest(URI url){
        if(url.getPath().equals("/")){
            return "This is the homepage of Bernico's String Server!";
        }
        else{
            if(url.getPath().contains("/add-message")){
                String[] queries = url.getQuery().split("=");
                if(queries[0].equals("s")){
                    String r = "";
                    dataList.add(queries[1]);
                    for(String strs: dataList){
                        r = r + strs + "\n";
                    }
                    return r;
                }
            }
        }
        return "ERROR! Page not found!";
    }
}

public class StringServer{
    public static void main(String[] args) throws IOException{
        if(args.length == 0){
            System.out.println("Missing port number!");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
