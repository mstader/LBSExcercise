/* Generated By:JavaCC: Do not edit this line. Compiler.java */
package at.fhooe.mcm.cas.compiler.generated;

import at.fhooe.mcm.cas.compiler.treenode.*;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
public class Compiler implements CompilerConstants {
public Compiler() {}
        public static void evaluate(String _expr) throws ParseException {
                InputStream input = new ByteArrayInputStream(_expr.getBytes());
                Compiler compiler = new Compiler(input);
                TreeNode root = compiler.stmt();
                root.setVariableParameters( new Object[] {  3 });
                try {
                        Object result = root.calculate();
                        System.out.println(result.toString());
                } catch (NodeError e) {
                        e.printStackTrace();
                }
        }
        public static void main(String[] _argv) {
                try {
                        Compiler.evaluate("TEMPERATURE < 4 & TEMPERATURE > 0");
                } catch (Exception _e) {
                        _e.printStackTrace();
                }
        }

  final public TreeNode stmt() throws ParseException {
TreeNode nodeA = null;
TreeNode root = null;
    nodeA = valueComparison();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LOGIC:
      root = logicalComparison(nodeA);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
                                                               if(root == null) {if (true) return nodeA;} else {if (true) return root;}
    throw new Error("Missing return statement in function");
  }

  // stmt nonterminal
  final public TreeNode valueComparison() throws ParseException {
TreeNode nodeA = null;
TreeNode root = null;
    nodeA = daytime_stmt();
    root = daytime_comparison(nodeA);
                                                          {if (true) return root;}
    throw new Error("Missing return statement in function");
  }

  final public TreeNode logicalComparison(TreeNode _nodeA) throws ParseException {
TreeNode root = null;
TreeNode nodeB = null;
Token t;
    t = jj_consume_token(LOGIC);
    nodeB = valueComparison();
root = new TreeNodeLogical(t.image);
root.setChilds(new TreeNode[]{ _nodeA, nodeB });
{if (true) return root;}
    throw new Error("Missing return statement in function");
  }

  final public TreeNode daytime_comparison(TreeNode _nodeA) throws ParseException {
TreeNode root = null;
TreeNode nodeB = null;
Token t;
    t = jj_consume_token(COMP);
    nodeB = daytime_stmt();
root = new TreeNodeComparator(t.image);
root.setChilds(new TreeNode[]{ _nodeA, nodeB });
{if (true) return root;}
    throw new Error("Missing return statement in function");
  }

  // daytime_comparison nonterminal
  final public TreeNode daytime_stmt() throws ParseException {
                            Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONELEM:
      t = jj_consume_token(CONELEM);
                {if (true) return new TreeNodeConstant(t.image);}
      break;
    case NUM:
      t = jj_consume_token(NUM);
              {if (true) return new TreeNodeContextVar(t.image);}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public CompilerTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200,0x140,};
   }

  /** Constructor with InputStream. */
  public Compiler(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Compiler(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CompilerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Compiler(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CompilerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Compiler(CompilerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CompilerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[10];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 10; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
