/* Generated By:JJTree: Do not edit this line. ASTAxisId.java */

package org.geoserver.wcs.kvp.rangesubset;

public class ASTAxisId extends SimpleNode {
  public ASTAxisId(int id) {
    super(id);
  }

  public ASTAxisId(RangeSubsetParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(RangeSubsetParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
