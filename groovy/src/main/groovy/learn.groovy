/**
 * �հ��ļ�ʾ��
 */
def str="hello"
def closure={
    println str
}
closure()

/**
 * �հ��ĵ�����2����ʽ
 * closure.call(params)
 * closure(params)
 */

def closure2={
    param->println param
}
closure2("��ʽ1")
closure2.call("��ʽ2")

/**
 * �հ������
 */
def closure3={ String x,int y ->
    println "hey ${x} the value is ${y}"
}

/**
 * ���ֻ��һ������������ʡ���䶨��
 * Groovy�ṩһ����ʽ�Ĳ���it �������
 */
def closure4={it->println it}

def closure5={println it}
closure4('with it')
closure5('without it')



