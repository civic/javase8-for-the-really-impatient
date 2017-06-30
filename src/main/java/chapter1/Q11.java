package chapter1;

public class Q11 {
    public static interface I_abstract {
        void f();
    }
    public static interface I_default {
        default void f(){ System.out.println("I_default f"); }
    }
    public static interface I_static {
        static void f(){System.out.println("I_static f");}
    }

    public static interface J_abstract {
        void f();
    }
    public static interface J_default {
        default void f(){ System.out.println("J_default f"); }
    }
    public static interface J_static {
        static void f(){System.out.println("J_static f");}
    }

   public static class AbstractAbstract implements I_abstract, J_abstract {
        @Override
        public void f() {
            System.out.println("abstract abstract");
        }
   }
   public static class AbstractDefault implements I_abstract, J_default {
        @Override
        public void f() {
            System.out.println("abstract default");
            J_default.super.f();
        }
   }
   public static class AbstractStatic implements I_abstract, J_static {
        @Override
        public void f() {
            System.out.println("abstract static");
        }
   }
   public static class DefaultAbstract implements I_default, J_abstract {
        @Override
        public void f() {
            System.out.println("default abstract");
        }
   }
   public static class DefaultDefault implements I_default, J_default {
        @Override
        public void f() {
            System.out.println("default default");
        }
   }
   public static class DefaulttStatic implements I_default, J_static {
   }

   public static class StaticAbstract implements I_static, J_abstract {
        @Override
        public void f() {
            System.out.println("static abstract");
        }
   }
   public static class StaticDefault implements I_static, J_default {
   }
   public static class StatictStatic implements I_static, J_static {
   }
    
    public static void main(String[] args) {
        AbstractAbstract aa = new AbstractAbstract();
        aa.f();
        AbstractDefault ad = new AbstractDefault();
        ad.f();
        AbstractStatic as = new AbstractStatic();
        as.f();
        StaticDefault sd = new StaticDefault();
        sd.f();
    }
}
