import java.util.PriorityQueue;

class HuffManNode implements Comparable<HuffManNode>{
    int freq;
    String symbol;
    HuffManNode left;
    HuffManNode right;
    String huff = "";

    HuffManNode(int freq,String symbol){
        this.freq = freq;
        this.symbol = symbol;
    }

    HuffManNode(int freq,String symbol, HuffManNode left,HuffManNode right){
        this.freq = freq;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffManNode other){
        return this.freq - other.freq;
    }
}

public class pr2{
    public static void printNodes(HuffManNode node, String val){
        String newVal = val + node.huff;
        if(node.left != null){
            printNodes(node.left,newVal);
        }
        if(node.right != null){
            printNodes(node.right,newVal);
        }
        if(node.left == null && node.right == null){
            System.out.println(node.symbol + "->" + newVal);
        }
    }

    public static void main(String args[]){
        String[] symbols = {"a","b","c","d","e","f"};
        int[] freqs = {50,10,30,5,3,2};

        PriorityQueue<HuffManNode> huffmanNodes = new PriorityQueue<HuffManNode>();

        for(int i = 0; i < symbols.length; i++){
            huffmanNodes.add(new HuffManNode(freqs[i],symbols[i]));
        }

        while(huffmanNodes.size() > 1){
            HuffManNode left = huffmanNodes.poll();
            HuffManNode right = huffmanNodes.poll();
            
            left.huff = "0";
            right.huff = "1";

            HuffManNode newNode = new HuffManNode(left.freq + right.freq, left.symbol + right.symbol, left,right);
            huffmanNodes.add(newNode);
        }

        printNodes(huffmanNodes.peek(),"");
    }
}