// -8<- [start:one]
public class ConfigClassExample implements ConfigClass {

}
// -8<- [end:one]
// -8<- [start:two]
@Override
public void validate() {

}
// -8<- [end:two]
// -8<- [start:three]
public class ConfigClassExample implements ConfigClass {
    public boolean foo = false; // (1)!

    public UtilConfig util_config = new UtilConfig() // (2)!

    public static class UtilConfig {
        public boolean debug_mode = false // (3)!

        public boolean suppress_warns = false
    }

    @Override
    public void validate() {

    }
}
// -8<- [end:three]
// -8<- [start:janksonComments]
@Comment("Very cool comment!")
public boolean foo = false;
@Comment("""
        Lorem ipsum is just a silly placeholder text that can definetly show the following:
        Having to use multi-line comments!""")
public boolean bar = true;
// -8<- [end:janksonComments]
// -8<- [start:janksonCommentsJson]
// Very cool comment!
"foo": false,
/*
    Lorem ipsum is just a silly placeholder text that can definitely show the following:
    Having to use multi-line comments!
*/
"bar": true
// -8<- [end:janksonCommentsJson]