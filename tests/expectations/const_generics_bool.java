import com.sun.jna.*;
import com.sun.jna.ptr.*;

enum BindingsSingleton {
  INSTANCE;
  final Bindings lib = Native.load("", Bindings.class);
}

interface Bindings extends Library {
  Bindings INSTANCE = BindingsSingleton.INSTANCE.lib;

  class Str extends PointerType {
    public Str() {
      super(null);
    }
    public Str(Pointer p) {
      super(p);
    }
  }

  class StrByReference extends Str {
    public StrByReference() {
      super(null);
    }
    public StrByReference(Pointer p) {
      super(p);
    }
  }


  @Structure.FieldOrder({"num_buckets", "capacity", "occupied", "keys", "vals"})
  class HashTable_Str__c_char__false extends Structure implements Structure.ByValue {
    public HashTable_Str__c_char__false() {
      super();
    }

    public HashTable_Str__c_char__false(Pointer p) {
      super(p);
    }

    public NativeLong num_buckets;
    public NativeLong capacity;
    public ByteByReference occupied;
    public StrByReference keys;
    public ByteByReference vals;

  }

  @Structure.FieldOrder({"num_buckets", "capacity", "occupied", "keys", "vals"})
  class HashTable_Str__c_char__falseByReference extends Structure implements Structure.ByReference {
    public HashTable_Str__c_char__falseByReference() {
      super();
    }

    public HashTable_Str__c_char__falseByReference(Pointer p) {
      super(p);
    }

    public NativeLong num_buckets;
    public NativeLong capacity;
    public ByteByReference occupied;
    public StrByReference keys;
    public ByteByReference vals;

  }


  class MySet extends HashTable_Str__c_char__false {
    public MySet() {
      super();
    }
    public MySet(Pointer p) {
      super(p);
    }
  }

  class MySetByReference extends HashTable_Str__c_char__falseByReference {
    public MySetByReference() {
      super();
    }
    public MySetByReference(Pointer p) {
      super(p);
    }
  }

  interface SetCallback extends Callback {
    void invoke(Str key);
  }


  @Structure.FieldOrder({"num_buckets", "capacity", "occupied", "keys", "vals"})
  class HashTable_Str__u64__true extends Structure implements Structure.ByValue {
    public HashTable_Str__u64__true() {
      super();
    }

    public HashTable_Str__u64__true(Pointer p) {
      super(p);
    }

    public NativeLong num_buckets;
    public NativeLong capacity;
    public ByteByReference occupied;
    public StrByReference keys;
    public LongByReference vals;

  }

  @Structure.FieldOrder({"num_buckets", "capacity", "occupied", "keys", "vals"})
  class HashTable_Str__u64__trueByReference extends Structure implements Structure.ByReference {
    public HashTable_Str__u64__trueByReference() {
      super();
    }

    public HashTable_Str__u64__trueByReference(Pointer p) {
      super(p);
    }

    public NativeLong num_buckets;
    public NativeLong capacity;
    public ByteByReference occupied;
    public StrByReference keys;
    public LongByReference vals;

  }


  interface MapCallback extends Callback {
    void invoke(Str key, long val);
  }

  MySetByReference new_set();

  void set_for_each(MySetByReference set, SetCallback callback);

  HashTable_Str__u64__trueByReference new_map();

  void map_for_each(HashTable_Str__u64__trueByReference map, MapCallback callback);

}