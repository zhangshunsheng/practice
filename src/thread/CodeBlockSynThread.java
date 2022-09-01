package thread;

/**
 * ClassName: CodeBlockSynThread
 * Description:
 * date: 2020/12/9 23:52
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class CodeBlockSynThread extends Thread {
    private CodeBlockSynTest codeBlockSynTest;

    public CodeBlockSynThread(CodeBlockSynTest codeBlockSynTest) {
        this.codeBlockSynTest = codeBlockSynTest;
    }

    @Override
    public void run() {
        super.run();
        this.codeBlockSynTest.sout();
    }
}
