1，序列化有什么方式

2、默认的序列化行为特性
当某个字段被声明为transient后，默认序列化机制就会忽略该字段。

ObjectOutputStream的序列化方法主要代码，

private void writeObject0(Object obj, boolean unshared) throws IOException {

    if (obj instanceof String) {
        writeString((String) obj, unshared);
    } else if (cl.isArray()) {
        writeArray(obj, desc, unshared);
    } else if (obj instanceof Enum) {
        writeEnum((Enum) obj, desc, unshared);
    } else if (obj instanceof Serializable) {
        writeOrdinaryObject(obj, desc, unshared);
    } else {
        if (extendedDebugInfo) {
            throw new NotSerializableException(cl.getName() + "\n"
                    + debugInfoStack.toString());
        } else {
            throw new NotSerializableException(cl.getName());
        }
    }

}
