/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.matching.subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfMatchingSubsequences {

    /**
     * @param args the command line arguments
     */
    
//    class Trie {
//        Trie[] arr;
//        int endCount;
//
//        public Trie() {
//            arr=new Trie[26];
//            endCount=0;
//        }
//        
//        public Trie addChar(char c) {
//            if(arr[c-'a']==null) arr[c-'a']=new Trie();
//            return arr[c-'a'];
//        }
//        
//        public Trie getAt(char c) {
//            return this.arr[c-'a'];
//        }
//        
//        public void setEnd() {
//            this.endCount++;
//        }
//        
//        public int getEnd() {
//            int t=this.endCount;
//            this.endCount=0;
//            return t;
//        }
//    }
//    
//    
//    public int numMatchingSubseq(String s, String[] words) {
//        Trie root=new Trie();
//        for(String w: words) {
//            Trie trie=root;
//            for(char c: w.toCharArray()) {
//                trie=trie.addChar(c);
//            }
//            trie.setEnd();
//        }
//        
//        Queue<Trie> queue=new LinkedList<>();
//        queue.offer(root);
//        int count=0;
//        for(char ss: s.toCharArray()) {
//            int size=queue.size();
//            Trie temp;
//            while(size>0) {
//                temp=queue.poll();
//                Trie forPosition = temp.getAt(ss);
//                if(forPosition!=null) {
//                    queue.offer(forPosition);
//                    count+=forPosition.getEnd();
//                    if(forPosition.endCount>0) System.out.print(ss+" ");
//                }
//                size--;
//                queue.offer(temp);
//            }
//        }
//        return count;
//    }
    
    
    public int numMatchingSubseq(String s, String[] words) {
        List<StringBuilder>[] list=new ArrayList[26];
        for(int i=0; i<26; i++) {
            list[i]=new ArrayList<>();
        }
        for(String w: words) {
            list[w.charAt(0)-'a'].add(new StringBuilder(w));
        }
        int count=0;
        for(char c: s.toCharArray()) {
            List<StringBuilder> t=list[c-'a'];
            list[c-'a']=new ArrayList<>();
            for(StringBuilder ss: t) {
                if(ss.length()==1) {
                    count++;
                } else {
                    ss.deleteCharAt(0);
                    list[ss.charAt(0)-'a'].add(ss);
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        NumberOfMatchingSubsequences n=new NumberOfMatchingSubsequences();
        System.out.println(n.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
        System.out.println(n.numMatchingSubseq("abcde", new String[]{"a","a","a","a"}));
        System.out.println(n.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
        System.out.println(n.numMatchingSubseq("ricogwqznwxxcpueelcobbbkuvxxrvgyehsudccpsnuxpcqobtvwkuvsubiidjtccoqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjscnlhbrhookmioxqighkxfugpeekgtdofwzemelpyjsdeeppapjoliqlhbrbghqjezzaxuwyrbczodtrhsvnaxhcjiyiphbglyolnswlvtlbmkrsurrcsgdzutwgjofowhryrubnxkahocqjzwwagqidjhwbunvlchojtbvnzdzqpvrazfcxtvhkruvuturdicnucvndigovkzrqiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqnhrewhagldzhryzdmmrwnxhaqfezeeabuacyswollycgiowuuudrgzmwnxaezuqlsfvchjfloczlwbefksxsbanrektvibbwxnokzkhndmdhweyeycamjeplecewpnpbshhidnzwopdjuwbecarkgapyjfgmanuavzrxricbgagblomyseyvoeurekqjyljosvbneofjzxtaizjypbcxnbfeibrfjwyjqrisuybfxpvqywqjdlyznmojdhbeomyjqptltpugzceyzenflfnhrptuugyfsghluythksqhmxlmggtcbdddeoincygycdpehteiugqbptyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjckmaptilrbfpjxiarmwalhbdjiwbaknvcqovwcqiekzfskpbhgxpyomekqvzpqyirelpadooxjhsyxjkfqavbaoqqvvknqryhotjritrkvdveyapjfsfzenfpuazdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzqfgqwhgobwyhxltligahroyshfndydvffd", 
                new String[]{"iowuuudrgzmw",                    "azfcxtvhkruvuturdicnucvndigovkzrq",                    "ylmmo",                    "maptilrbfpjxiarmwalhbd",                    "oqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqgl",                    "ytldcdlxqbaszbuxsacqwqnhrewhagldzhr",                    "zeeab",                    "cqie",                    "pvrazfcxtvhkruvuturdicnucvndigovkzrqiya",                    "zxnvpluwicurrtshyvevkriudayyysepzq",                    "wyhxltligahroyshfn",                    "nhrewhagldzhryzdmmrwn",                    "yqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmw",                    "nhrptuugyfsghluythksqhmxlmggtcbdd",                    "yligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjsc",                    "zdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzq",                    "ncygycdpehteiugqbptyqbvokpwovbnplshnzafun",                    "gdzutwgjofowhryrubnxkahocqjzww",                    "eppapjoliqlhbrbgh",                    "qwhgobwyhxltligahroys",                    "dzutwgjofowhryrubnxkah","rydhxkdhffyytldcdlxqbaszbuxs",                    "tyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjc","khvyjyrydhxkdhffyytldcdlxqbasz",                    "jajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqn","ppapjoliqlhbrbghq",                    "zmwwxzjckmaptilrbfpjxiarm","nxkahocqjzwwagqidjhwbunvlchoj",                    "ybfxpvqywqjdlyznmojdhbeomyjqptltp","udrgzmwnxae","nqglnpjvwddvdlmjjyzmww",                    "swlvtlbmkrsurrcsgdzutwgjofowhryrubn","hudqbfnzxnvpluwicurr","xaezuqlsfvchjf",                    "tvibbwxnokzkhndmdhweyeycamjeplec","olnswlvtlbmkrsurrcsgdzu",                    "qiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyyt","eiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwyl",                    "cgiowuuudrgzmwnxaezuqlsfvchjflocz","rxric","cygycdpehteiugqbptyqbvokpwovbnplshnzaf","g",                    "surrcsgd","yzenflfnhrptuugyfsghluythksqh","gdzutwgjofowhryrubnxkahocqjzwwagqid",                    "ddeoincygycdpeh","yznmojdhbeomyjqptltpugzceyzenflfnhrptuug","ejuisks",                    "teiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoi","mrwnxhaqfezeeabuacyswollycgio",                    "qfskkpfakjretogrokmxemjjbvgmmqrfdxlkfvycwalbdeumav","wjgjhlrpvhqozvvkifhftnfqcfjmmzhtxsoqbeduqmnpvimagq",                    "ibxhtobuolmllbasaxlanjgalgmbjuxmqpadllryaobcucdeqc","ydlddogzvzttizzzjohfsenatvbpngarutztgdqczkzoenbxzv",                    "rmsakibpprdrttycxglfgtjlifznnnlkgjqseguijfctrcahbb","pqquuarnoybphojyoyizhuyjfgwdlzcmkdbdqzatgmabhnpuyh",                    "akposmzwykwrenlcrqwrrvsfqxzohrramdajwzlseguupjfzvd","vyldyqpvmnoemzeyxslcoysqfpvvotenkmehqvopynllvwhxzr",                    "ysyskgrbolixwmffygycvgewxqnxvjsfefpmxrtsqsvpowoctw","oqjgumitldivceezxgoiwjgozfqcnkergctffspdxdbnmvjago",                    "bpfgqhlkvevfazcmpdqakonkudniuobhqzypqlyocjdngltywn","ttucplgotbiceepzfxdebvluioeeitzmesmoxliuwqsftfmvlg",                    "xhkklcwblyjmdyhfscmeffmmerxdioseybombzxjatkkltrvzq","qkvvbrgbzzfhzizulssaxupyqwniqradvkjivedckjrinrlxgi",                    "itjudnlqncbspswkbcwldkwujlshwsgziontsobirsvskmjbrq","nmfgxfeqgqefxqivxtdrxeelsucufkhivijmzgioxioosmdpwx",                    "ihygxkykuczvyokuveuchermxceexajilpkcxjjnwmdbwnxccl","etvcfbmadfxlprevjjnojxwonnnwjnamgrfwohgyhievupsdqd","ngskodiaxeswtqvjaqyulpedaqcchcuktfjlzyvddfeblnczmh","vnmntdvhaxqltluzwwwwrbpqwahebgtmhivtkadczpzabgcjzx","yjqqdvoxxxjbrccoaqqspqlsnxcnderaewsaqpkigtiqoqopth","wdytqvztzbdzffllbxexxughdvetajclynypnzaokqizfxqrjl","yvvwkphuzosvvntckxkmvuflrubigexkivyzzaimkxvqitpixo","lkdgtxmbgsenzmrlccmsunaezbausnsszryztfhjtezssttmsr","idyybesughzyzfdiibylnkkdeatqjjqqjbertrcactapbcarzb","ujiajnirancrfdvrfardygbcnzkqsvujkhcegdfibtcuxzbpds","jjtkmalhmrknaasskjnixzwjgvusbozslrribgazdhaylaxobj","nizuzttgartfxiwcsqchizlxvvnebqdtkmghtcyzjmgyzszwgi","egtvislckyltpfogtvfbtxbsssuwvjcduxjnjuvnqyiykvmrxl","ozvzwalcvaobxbicbwjrububyxlmfcokdxcrkvuehbnokkzala","azhukctuheiwghkalboxfnuofwopsrutamthzyzlzkrlsefwcz","yhvjjzsxlescylsnvmcxzcrrzgfhbsdsvdfcykwifzjcjjbmmu","tspdebnuhrgnmhhuplbzvpkkhfpeilbwkkbgfjiuwrdmkftphk","jvnbeqzaxecwxspuxhrngmvnkvulmgobvsnqyxdplrnnwfhfqq","bcbkgwpfmmqwmzjgmflichzhrjdjxbcescfijfztpxpxvbzjch","bdrkibtxygyicjcfnzigghdekmgoybvfwshxqnjlctcdkiunob","koctqrqvfftflwsvssnokdotgtxalgegscyeotcrvyywmzescq","boigqjvosgxpsnklxdjaxtrhqlyvanuvnpldmoknmzugnubfoa","jjtxbxyazxldpnbxzgslgguvgyevyliywihuqottxuyowrwfar","zqsacrwcysmkfbpzxoaszgqqsvqglnblmxhxtjqmnectaxntvb","izcakfitdhgujdborjuhtwubqcoppsgkqtqoqyswjfldsbfcct","rroiqffqzenlerchkvmjsbmoybisjafcdzgeppyhojoggdlpzq","xwjqfobmmqomhczwufwlesolvmbtvpdxejzslxrvnijhvevxmc","ccrubahioyaxuwzloyhqyluwoknxnydbedenrccljoydfxwaxy","jjoeiuncnvixvhhynaxbkmlurwxcpukredieqlilgkupminjaj","pdbsbjnrqzrbmewmdkqqhcpzielskcazuliiatmvhcaksrusae","nizbnxpqbzsihakkadsbtgxovyuebgtzvrvbowxllkzevktkuu","hklskdbopqjwdrefpgoxaoxzevpdaiubejuaxxbrhzbamdznrr","uccnuegvmkqtagudujuildlwefbyoywypakjrhiibrxdmsspjl",                    "awinuyoppufjxgqvcddleqdhbkmolxqyvsqprnwcoehpturicf"}));
    }
}
