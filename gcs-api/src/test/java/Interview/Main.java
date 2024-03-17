package Interview;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



    public class Main {

        public static void main(String[] args) {

            String str = "ThousifDM123";
            String reverse = "";
            for(int i= str.length()-1;i>=0;i--){


                char c = str.charAt(i);
                if(((c>='A' && c<='Z')|| (c>='a' && c<='z'))){
                    //System.out.print(c);
                    reverse += str.charAt(i);
                }

            }

            System.out.print(reverse);
        }

        }

