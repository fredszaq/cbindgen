
import com.sun.jna.*;
import com.sun.jna.ptr.*;

enum BindingsSingleton {
  INSTANCE;
  final Bindings lib = Native.load("", Bindings.class);
}

interface Bindings extends Library {
  Bindings INSTANCE = BindingsSingleton.INSTANCE.lib;

  class BarType extends IntegerType {
    public BarType() {
      super(4);
    }

    public BarType(long value) {
      super(4, value);
    }

    public BarType(Pointer p) {
      this(p.getInt(0));
    }
    public static final BarType A = new BarType(1);
    public static final BarType B = new BarType(2);
    public static final BarType C = new BarType(3);

  }

  class BarTypeByReference extends ByReference {
    public BarTypeByReference() {
      super(4);
    }

    public BarTypeByReference(Pointer p) {
      super(4);
      setPointer(p);
    }

    public BarType getValue() {
      return new BarType(getPointer().getInt(0));
    }

    public void setValue(BarType value) {
      getPointer().setInt(0, value.intValue());
    }

  }

  class FooType extends IntegerType {
    public FooType() {
      super(4);
    }

    public FooType(long value) {
      super(4, value);
    }

    public FooType(Pointer p) {
      this(p.getInt(0));
    }
    public static final FooType A = new FooType(1);
    public static final FooType B = new FooType(2);
    public static final FooType C = new FooType(3);

  }

  class FooTypeByReference extends ByReference {
    public FooTypeByReference() {
      super(4);
    }

    public FooTypeByReference(Pointer p) {
      super(4);
      setPointer(p);
    }

    public FooType getValue() {
      return new FooType(getPointer().getInt(0));
    }

    public void setValue(FooType value) {
      getPointer().setInt(0, value.intValue());
    }

  }


  @Structure.FieldOrder({"ty", "x", "y"})
  class FooHandle extends Structure implements Structure.ByValue {
    public FooHandle() {
      super();
    }

    public FooHandle(Pointer p) {
      super(p);
    }

    public FooType ty;
    public int x;
    public float y;

  }

  @Structure.FieldOrder({"ty", "x", "y"})
  class FooHandleByReference extends Structure implements Structure.ByReference {
    public FooHandleByReference() {
      super();
    }

    public FooHandleByReference(Pointer p) {
      super(p);
    }

    public FooType ty;
    public int x;
    public float y;

  }


  class C extends IntegerType {
    public C() {
      super(4);
    }

    public C(long value) {
      super(4, value);
    }

    public C(Pointer p) {
      this(p.getInt(0));
    }
    public static final C C1 = new C(1);
    public static final C C2 = new C(2);
    public static final C C3 = new C(3);
    public static final C C5 = new C(4);

  }

  class CByReference extends ByReference {
    public CByReference() {
      super(4);
    }

    public CByReference(Pointer p) {
      super(4);
      setPointer(p);
    }

    public C getValue() {
      return new C(getPointer().getInt(0));
    }

    public void setValue(C value) {
      getPointer().setInt(0, value.intValue());
    }

  }


  @Structure.FieldOrder({"ty", "x", "y"})
  class BarHandle extends Structure implements Structure.ByValue {
    public BarHandle() {
      super();
    }

    public BarHandle(Pointer p) {
      super(p);
    }

    public BarType ty;
    public int x;
    public float y;

  }

  @Structure.FieldOrder({"ty", "x", "y"})
  class BarHandleByReference extends Structure implements Structure.ByReference {
    public BarHandleByReference() {
      super();
    }

    public BarHandleByReference(Pointer p) {
      super(p);
    }

    public BarType ty;
    public int x;
    public float y;

  }



  @Structure.FieldOrder({"field"})
  class ConditionalField extends Structure implements Structure.ByValue {
    public ConditionalField() {
      super();
    }

    public ConditionalField(Pointer p) {
      super(p);
    }

    public int field;

  }

  @Structure.FieldOrder({"field"})
  class ConditionalFieldByReference extends Structure implements Structure.ByReference {
    public ConditionalFieldByReference() {
      super();
    }

    public ConditionalFieldByReference(Pointer p) {
      super(p);
    }

    public int field;

  }


  void root(FooHandle a, C c);

  void root(BarHandle a, C c);

  void cond(ConditionalField a);

}