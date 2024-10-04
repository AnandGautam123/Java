import java.util.*;

public class App {
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
    public static boolean isAnagram(String str1,String str2){
        if(str1.length()!=str2.length()) return false;
        HashMap<Character,Integer > hs= new HashMap<>();
        for(int i=0;i<str1.length();i++){
            if(hs.containsKey(str1.charAt(i))){
                int j=hs.get(str1.charAt(i));
                hs.put(str1.charAt(i), j+1);
            }else{
                hs.put(str1.charAt(i),1);
            }
        }
        for(int i=0;i<str1.length();i++){
            if(hs.containsKey(str2.charAt(i))){
                int j=hs.get(str1.charAt(i));
                hs.put(str1.charAt(i), j-1);
            }else{
                return false;
            }
        }
        for(int count : hs.values()){
            if(count !=0) return false;
        }
        return true;
    }
    public static int countWords(String str){
        int count =0;
        if(str.charAt(0)!=' '){
            count++;
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                count++;
            }
        }
        return count;
    }
    public static String removeDup(String str) {
        HashSet<Character> hs = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (!hs.contains(currentChar)) {
                hs.add(currentChar);
                ans.append(currentChar);
            }
        }
        return ans.toString();
    }  
    public static Boolean isPanagram(String str){
        str=str.toLowerCase();
        if(str.length()<26) return false;
        for(char ch='a';ch<='z';ch++){
            if(str.indexOf(ch)<0){
                return false;
            }
        }
        return true;
    }
    public static String longestSubstring(String str){
        HashSet<Character> hs= new HashSet<>();
        String longestOverall="";
        String longestTill ="";
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            if(hs.contains(c)){
                longestTill="";
                hs.clear();
            }
            hs.add(c);
            longestTill +=c;
            if(longestOverall.length()<longestTill.length()){
                longestOverall=longestTill;
            }
        }
        return longestOverall;
    }
    public static String compressedString(String str){
        HashMap<Character,Integer> hm= new HashMap<>();
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                int j= hm.get(str.charAt(i));
                hm.put(str.charAt(i), j+1);
            }else{
                hm.put(str.charAt(i), 1);
            }
        }
        for(Map.Entry<Character,Integer> entry : hm.entrySet()){
            ans.append(entry.getKey());
            ans.append(entry.getValue());
        }
        return ans.toString();
    }
    public static int highestProfit(int[] arr){
        int highest=0;
        int index=0;
        int lowest=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>highest){
                highest = arr[i];
                index=i;
            }
        }
        for(int i=0;i<index;i++){
            if(arr[i]<lowest){
                lowest = arr[i];
            }
        }
        return highest-lowest;
    }
    public static int[] twoSum(int[] arr,int a){
        int[] ans = new int[2];
        boolean found=false;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==a){
                    ans[0]=i;
                    ans[1]=j;
                    found=true;
                }
                if(found==true) break;
            }
            if(found==true) break;
        }
        return ans;
        
    }

    public static int aggressiveCow(int[] arr,int n){
        Arrays.sort(arr);
        int low=0;
        int high= arr[arr.length-1]-arr[0];
        while(low<=high){
            int mid=(high+low)/2;
            if(possible(arr,mid,n)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }
    static boolean possible(int[] arr,int mid,int cows){
        int cnt=1;
        int last=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]-last>=mid){
                cnt++;
                last=arr[i];
            }
            if(cnt>=cows) return true;
        }
        return false;
    }
    // static int average(int a , int b, int c){
    //     return (a+b+c)/3;
    // }
    // static int averagearray(int[] arr){
    //     int n = arr.length;
    //     int sum=0;
    //     for(int i=0;i<n;i++){
    //         sum += arr[i];
    //     }
    //     return sum/n;
    // }
    public static int repeatedTwice(int [] arr){
        int n = arr.length;
        int actual = n* (n+1)/2;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        return actual-sum;
    }
    public static String reverse(String str) {
        int n = str.length();
        StringBuilder ans = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }
    public static boolean isPalindrome(String str){
        String ans=reverse(str);
        int n= str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i)!=ans.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Integer> ArrayListDecending(ArrayList<Integer> arr){
        Collections.sort(arr, (a, b) -> b - a);
        return arr;
    }
    // public static LinkedList middleElement(LinkedList head){
    //     Node fast =0;
    //     Node slow =0;
    //     while(head != null){
    //         slow += 1 ;
    //         fast +=2;
    //     }
    //     return slow.data; 
    // }
    // public void removeDuplicates(LinkedList head) {
    //     if (head == null) return;

    //     HashSet<Integer> set = new HashSet<>();
    //     Node current = head;
    //     Node prev = null;

    //     while (current != null) {
    //         if (set.contains(current.data)) {
    //             prev.next = current.next;
    //         } else {
    //             set.add(current.data);
    //             prev = current;
    //         }
    //         current = current.next;
    //     }
    // }
    public static int minNotes(int amount, List<Integer> result) {
        int [] notes ={500, 100, 50, 10, 5, 2, 1};
        if (amount == 0) {
            return 0;
        }
        for (int i=0;i<notes.length;i++) {
            if (amount >= notes[i]) {
                result.add(notes[i]);
                return 1 + minNotes(amount - notes[i], result);
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        // Uncomment this block if you want to read and process roll numbers
        try (Scanner sc = new Scanner(System.in)) {
            // Uncomment this block if you want to read and process roll numbers
            int n = sc.nextInt();
            int a=sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            // for (int i = 0; i < n; i++) {
            //     System.out.print(fib(i) + " ");
            // }
            
            // Read a string and reverse it
            // String str1 = sc.nextLine();
            // String str2=sc.nextLine();
            // System.out.println(isAnagram(str1, str2));
            // System.out.println(countWords(str1));
            // System.out.println(isPalindrome(str));
            // System.out.println(removeDup(str1));
            // System.out.println(isPanagram(str1));
            // System.out.println(longestSubstring(str1));
            // System.out.println(compressedString(str1));
            // System.out.println(highestProfit(arr));
            int [] ans = twoSum(arr, a);
            for(int i=0;i<2;i++){
                System.out.println(ans[i]);
            }
        }
    }
}

