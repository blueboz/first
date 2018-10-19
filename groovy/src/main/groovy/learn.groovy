/**
 * 闭包的简单示例
 */
def str="hello"
def closure={
    println str
}
closure()

/**
 * 闭包的调用有2种形式
 * closure.call(params)
 * closure(params)
 */

def closure2={
    param->println param
}
closure2("方式1")
closure2.call("方式2")

/**
 * 闭包多参数
 */
def closure3={ String x,int y ->
    println "hey ${x} the value is ${y}"
}

/**
 * 如果只有一个参数，可以省略其定义
 * Groovy提供一个隐式的参数it 来替代他
 */
def closure4={it->println it}

def closure5={println it}
closure4('with it')
closure5('without it')



