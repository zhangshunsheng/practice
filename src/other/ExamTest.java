package other;

/**
 * ClassName: ExamTest
 * Description:
 * date: 2022/5/15 21:08
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class ExamTest {

    public String longestWord (String[] words) {
        // write code here
        String longestWord = null;
//        sortWords(words);
        mergeSortWords(words, 0, words.length - 1);
        for(int i = 0; i < words.length - 1; i++) {
            if(checkWord(words, words[i], i + 1)) {
                if(longestWord != null) {
                    if(longestWord.length() > words[i].length()) {
                        return longestWord;
                    }
                    longestWord = getBigCharacter(longestWord, words[i]);
                    continue;
                }
                longestWord = words[i];
            }
        }
        return longestWord;
    }

    public boolean checkWord(String[] words, String compareWord, int compareIndex) {
        for(int i = compareIndex; i < words.length; i++) {
            if(words[i].equals(compareWord.substring(0, words[i].length()))) {
                if(words[i].equals(compareWord)) {
                    return true;
                }

                String newComWord = compareWord.substring(words[i].length(), compareWord.length());
                int newCompareIndex = findCompareIndex(words, newComWord);
                return newCompareIndex == -1 ? false : checkWord(words, newComWord, newCompareIndex);
            }
        }
        return false;
    }

    public int findCompareIndex(String[] words, String compareWord) {
        int length = compareWord.length();
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() <= length) {
                return i;
            }
        }
        return -1;
    }

    public String getBigCharacter(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        for(int i = 0; i < aChar.length; i++) {
            if(aChar[i] != bChar[i]) {
                return aChar[i] < bChar[i] ? a : b;
            }
        }
        return a;
    }

    public void sortWords(String[] words) {
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i; j < words.length; j++) {
                if(words[j].length() > words[i].length()) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
    }

    public void mergeSortWords(String[] words, int start, int end) {
        if(start == end) {
            return;
        }
        int mid = (start + end) >>> 1;
        mergeSortWords(words, start, mid);
        mergeSortWords(words, mid + 1, end);
        mergeWords(words, start, end);
    }

    public void mergeWords(String[] words, int st, int end) {
        int start = st;
        int mid = (start + end) >>> 1;
        int rStart = mid + 1;
        String[] newWords = new String[end - start + 1];
        int count = 0;
        while(start <= mid && rStart <= end) {
            if(words[start].length() < words[rStart].length()) {
                newWords[count] = words[rStart];
                rStart++;
            } else {
                newWords[count] = words[start];
                start++;
            }
            count++;
        }
        while(start <= mid) {
            newWords[count] = words[start];
            start++;
            count++;
        }
        while(rStart <= end) {
            newWords[count] = words[rStart];
            rStart++;
            count++;
        }
        for(int i = 0; i < newWords.length; i++) {
            words[st + i] = newWords[i];
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple","iOS","dog","nana","man", "good", "goodiOS","goodman", "appleiOSman"};
        ExamTest test = new ExamTest();
        System.out.println(test.longestWord(words));
    }
}
