/*
  Licensed under the Apache License, Version 2.0
    http://www.apache.org/licenses/LICENSE-2.0.html

  AUTOGENERATED BY H2O at 2019-03-09T13:45:46.963-05:00
  3.22.1.3
  
  Standalone prediction code with sample test data for GLMModel named regression

  How to download, compile and execute:
      mkdir tmpdir
      cd tmpdir
      curl http://127.0.0.1:54321/3/h2o-genmodel.jar > h2o-genmodel.jar
      curl http://127.0.0.1:54321/3/Models.java/regression > regression.java
      javac -cp h2o-genmodel.jar -J-Xmx2g -J-XX:MaxPermSize=128m regression.java

     (Note:  Try java argument -XX:+PrintCompilation to show runtime JIT compiler behavior.)
*/
import java.util.Map;
import hex.genmodel.GenModel;
import hex.genmodel.annotations.ModelPojo;

@ModelPojo(name="regression", algorithm="glm")
public class regression extends GenModel {
  public hex.ModelCategory getModelCategory() { return hex.ModelCategory.Binomial; }

  public boolean isSupervised() { return true; }
  public int nfeatures() { return 12; }
  public int nclasses() { return 2; }

  // Names of columns used by model.
  public static final String[] NAMES = NamesHolder_regression.VALUES;
  // Number of output classes included in training data response column.
  public static final int NCLASSES = 2;

  // Column domains. The last array contains domain of response column.
  public static final String[][] DOMAINS = new String[][] {
    /* offer */ regression_ColInfo_0.VALUES,
    /* week */ regression_ColInfo_1.VALUES,
    /* category */ regression_ColInfo_2.VALUES,
    /* brand */ regression_ColInfo_3.VALUES,
    /* company */ regression_ColInfo_4.VALUES,
    /* day_of_week */ regression_ColInfo_5.VALUES,
    /* purchased */ regression_ColInfo_6.VALUES,
    /* month */ regression_ColInfo_7.VALUES,
    /* offervalue */ null,
    /* mean_quantity */ null,
    /* mean_amount */ null,
    /* day_of_month */ null,
    /* repeater */ regression_ColInfo_12.VALUES
  };
  // Prior class distribution
  public static final double[] PRIOR_CLASS_DISTRIB = null;
  // Class distribution used for model building
  public static final double[] MODEL_CLASS_DISTRIB = null;

  public regression() { super(NAMES,DOMAINS,"repeater"); }
  public String getUUID() { return Long.toString(5578395095672662960L); }

  // Pass in data in a double[], pre-aligned to the Model's requirements.
  // Jam predictions into the preds[] array; preds[0] is reserved for the
  // main prediction (class for classifiers or value for regression),
  // and remaining columns hold a probability distribution for classifiers.
  public final double[] score0( double[] data, double[] preds ) {
    final double [] b = BETA.VALUES;
    for(int i = 0; i < 8; ++i) if(Double.isNaN(data[i])) data[i] = CAT_MODES.VALUES[i];
    for(int i = 0; i < 4; ++i) if(Double.isNaN(data[i + 8])) data[i+8] = NUM_MEANS.VALUES[i];
    double eta = 0.0;
    for(int i = 0; i < CATOFFS.length-1; ++i) {
      int ival = (int)data[i];
      if(ival != data[i]) throw new IllegalArgumentException("categorical value out of range");
      ival += CATOFFS[i];
      if(ival < CATOFFS[i + 1])
        eta += b[ival];
    }
    for(int i = 8; i < b.length-1-54; ++i)
    eta += b[54+i]*data[i];
    eta += b[b.length-1]; // reduce intercept
    double mu = hex.genmodel.GenModel.GLM_logitInv(eta);
    preds[0] = (mu >= 0.22712753421144893) ? 1 : 0; // threshold given by ROC
    preds[1] = 1.0 - mu; // class 0
    preds[2] =       mu; // class 1
    return preds;
  }
    public static class BETA implements java.io.Serializable {
      public static final double[] VALUES = new double[67];
      static {
        BETA_0.fill(VALUES);
      }
      static final class BETA_0 implements java.io.Serializable {
        static final void fill(double[] sa) {
          sa[0] = 0.0;
          sa[1] = 0.1082158423268683;
          sa[2] = -0.059469076823214284;
          sa[3] = -0.19260090640792926;
          sa[4] = 0.0;
          sa[5] = -0.13160511907278233;
          sa[6] = 0.0;
          sa[7] = 0.04566767667299378;
          sa[8] = -0.24222787583896932;
          sa[9] = -0.07430314216570119;
          sa[10] = 0.0;
          sa[11] = 0.0;
          sa[12] = 0.8842485147123613;
          sa[13] = 0.01051949144013869;
          sa[14] = 0.5584263300330863;
          sa[15] = 0.0;
          sa[16] = -0.23952873041846412;
          sa[17] = 0.4305071492369469;
          sa[18] = 0.405141017326411;
          sa[19] = -0.34637257547304967;
          sa[20] = -0.051391921401202266;
          sa[21] = -0.1498195725718091;
          sa[22] = -0.16305679771423606;
          sa[23] = 0.0;
          sa[24] = -0.1490882002247329;
          sa[25] = 0.0;
          sa[26] = 0.19571788672347615;
          sa[27] = -0.11170191626369788;
          sa[28] = 0.01051949144013903;
          sa[29] = 0.6652083041069655;
          sa[30] = 0.04566767667299392;
          sa[31] = 0.0;
          sa[32] = -0.24222787583897043;
          sa[33] = -0.10399726349987923;
          sa[34] = 0.1261040914679376;
          sa[35] = -0.23952873041846545;
          sa[36] = -0.10399726349987906;
          sa[37] = -0.24222787583897126;
          sa[38] = 0.66520830410698;
          sa[39] = 0.0;
          sa[40] = 0.12610409146793794;
          sa[41] = 0.010519491440137864;
          sa[42] = -0.9572762215211219;
          sa[43] = 0.0;
          sa[44] = 0.0;
          sa[45] = -0.2422278758389701;
          sa[46] = 0.0;
          sa[47] = -0.10399726349988006;
          sa[48] = 0.010519491440137379;
          sa[49] = 0.12610409146793727;
          sa[50] = 0.0;
          sa[51] = -0.052628956587827;
          sa[52] = -0.04493026916158456;
          sa[53] = 0.0;
          sa[54] = 0.0;
          sa[55] = 0.02139064717962516;
          sa[56] = 0.10459426750319768;
          sa[57] = 0.03969146192300534;
          sa[58] = -0.5895878766260355;
          sa[59] = 0.21534992062671984;
          sa[60] = 0.07650616464353761;
          sa[61] = -0.06607750158234982;
          sa[62] = -1.017159357425768;
          sa[63] = 0.0010556846896046153;
          sa[64] = 0.0827534389521688;
          sa[65] = -0.033103829302917866;
          sa[66] = 1.3727622614166752;
        }
      }
}
// Imputed numeric values
    static class NUM_MEANS implements java.io.Serializable {
      public static final double[] VALUES = new double[4];
      static {
        NUM_MEANS_0.fill(VALUES);
      }
      static final class NUM_MEANS_0 implements java.io.Serializable {
        static final void fill(double[] sa) {
          sa[0] = 1.253458251458157;
          sa[1] = 0.6953023238226143;
          sa[2] = 2.2353093287473143;
          sa[3] = 19.042996163563263;
        }
      }
}
// Imputed categorical values.
    static class CAT_MODES implements java.io.Serializable {
      public static final int[] VALUES = new int[8];
      static {
        CAT_MODES_0.fill(VALUES);
      }
      static final class CAT_MODES_0 implements java.io.Serializable {
        static final void fill(int[] sa) {
          sa[0] = 16;
          sa[1] = 4;
          sa[2] = 8;
          sa[3] = 7;
          sa[4] = 6;
          sa[5] = 0;
          sa[6] = 0;
          sa[7] = 1;
        }
      }
}
    // Categorical Offsets
    public static final int[] CATOFFS = {0,17,27,36,44,51,58,60,62};
}
// The class representing training column names
class NamesHolder_regression implements java.io.Serializable {
  public static final String[] VALUES = new String[12];
  static {
    NamesHolder_regression_0.fill(VALUES);
  }
  static final class NamesHolder_regression_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "offer";
      sa[1] = "week";
      sa[2] = "category";
      sa[3] = "brand";
      sa[4] = "company";
      sa[5] = "day_of_week";
      sa[6] = "purchased";
      sa[7] = "month";
      sa[8] = "offervalue";
      sa[9] = "mean_quantity";
      sa[10] = "mean_amount";
      sa[11] = "day_of_month";
    }
  }
}
// The class representing column offer
class regression_ColInfo_0 implements java.io.Serializable {
  public static final String[] VALUES = new String[17];
  static {
    regression_ColInfo_0_0.fill(VALUES);
  }
  static final class regression_ColInfo_0_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "1198271";
      sa[1] = "1198272";
      sa[2] = "1198273";
      sa[3] = "1198274";
      sa[4] = "1198275";
      sa[5] = "1200581";
      sa[6] = "1200582";
      sa[7] = "1200584";
      sa[8] = "1204576";
      sa[9] = "1204821";
      sa[10] = "1204822";
      sa[11] = "1208251";
      sa[12] = "1208252";
      sa[13] = "1208329";
      sa[14] = "1208501";
      sa[15] = "1208503";
      sa[16] = "unknown";
    }
  }
}
// The class representing column week
class regression_ColInfo_1 implements java.io.Serializable {
  public static final String[] VALUES = new String[10];
  static {
    regression_ColInfo_1_0.fill(VALUES);
  }
  static final class regression_ColInfo_1_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "9";
      sa[1] = "10";
      sa[2] = "11";
      sa[3] = "12";
      sa[4] = "13";
      sa[5] = "14";
      sa[6] = "15";
      sa[7] = "16";
      sa[8] = "17";
      sa[9] = "18";
    }
  }
}
// The class representing column category
class regression_ColInfo_2 implements java.io.Serializable {
  public static final String[] VALUES = new String[9];
  static {
    regression_ColInfo_2_0.fill(VALUES);
  }
  static final class regression_ColInfo_2_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "1726";
      sa[1] = "2119";
      sa[2] = "2202";
      sa[3] = "3504";
      sa[4] = "5558";
      sa[5] = "5616";
      sa[6] = "5619";
      sa[7] = "6202";
      sa[8] = "unknown";
    }
  }
}
// The class representing column brand
class regression_ColInfo_3 implements java.io.Serializable {
  public static final String[] VALUES = new String[8];
  static {
    regression_ColInfo_3_0.fill(VALUES);
  }
  static final class regression_ColInfo_3_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "102504";
      sa[1] = "15889";
      sa[2] = "3718";
      sa[3] = "5072";
      sa[4] = "64486";
      sa[5] = "6926";
      sa[6] = "7668";
      sa[7] = "unknown";
    }
  }
}
// The class representing column company
class regression_ColInfo_4 implements java.io.Serializable {
  public static final String[] VALUES = new String[7];
  static {
    regression_ColInfo_4_0.fill(VALUES);
  }
  static final class regression_ColInfo_4_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "104460040";
      sa[1] = "104610040";
      sa[2] = "107120272";
      sa[3] = "107717272";
      sa[4] = "108079383";
      sa[5] = "1087744888";
      sa[6] = "unknown";
    }
  }
}
// The class representing column day_of_week
class regression_ColInfo_5 implements java.io.Serializable {
  public static final String[] VALUES = new String[7];
  static {
    regression_ColInfo_5_0.fill(VALUES);
  }
  static final class regression_ColInfo_5_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "Mon";
      sa[1] = "Tue";
      sa[2] = "Wed";
      sa[3] = "Thu";
      sa[4] = "Fri";
      sa[5] = "Sat";
      sa[6] = "Sun";
    }
  }
}
// The class representing column purchased
class regression_ColInfo_6 implements java.io.Serializable {
  public static final String[] VALUES = new String[2];
  static {
    regression_ColInfo_6_0.fill(VALUES);
  }
  static final class regression_ColInfo_6_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "0";
      sa[1] = "1";
    }
  }
}
// The class representing column month
class regression_ColInfo_7 implements java.io.Serializable {
  public static final String[] VALUES = new String[2];
  static {
    regression_ColInfo_7_0.fill(VALUES);
  }
  static final class regression_ColInfo_7_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "3";
      sa[1] = "4";
    }
  }
}
// The class representing column repeater
class regression_ColInfo_12 implements java.io.Serializable {
  public static final String[] VALUES = new String[2];
  static {
    regression_ColInfo_12_0.fill(VALUES);
  }
  static final class regression_ColInfo_12_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "0";
      sa[1] = "1";
    }
  }
}

