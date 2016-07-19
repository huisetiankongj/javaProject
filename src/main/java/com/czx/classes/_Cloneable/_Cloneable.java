package com.czx.classes._Cloneable;

/**
 * Cloneable接口没有定义成员。
 * 它通常用于指明被创建的一个允许对对象进行位复制（也就是对象副本）的类。
 * 如果试图用一个不支持Cloneable接口的类调用clone( )方法，
 * 将引发一个CloneNotSupportedException异常。
 * 当一个副本被创建时，并没有调用被复制对象的构造函数。
 * 副本仅仅是原对象的一个简单精确的拷贝。
 * 复制是一个具有潜在危险的操作，因为它可能引起不是你所期望的副作用。
 * 例如，假如被复制的对象包含了一个称为obRef的引用变量，
 * 当副本创建时，副本中的obRef如同原对象中的obRef一样引用相同的对象。
 * 如果副本改变了被obRef引用的对象的内容，那么对应的原对象也将被改变。
 * 这里是另一个例子。如果一个对象打开一个I/O流并被复制，两个对象将可操作相同的流。
 * 而且，如果其中一个对象关闭了流，而另一个对象仍试图对I/O流进行写操作的话，将导致错误。
 * @author admin
 *
 */
public class _Cloneable {

}
