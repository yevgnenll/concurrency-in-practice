package com.example.concurrent.safe

import com.example.concurrent.annotation.ThreadSafe
import java.math.BigInteger
import javax.servlet.Servlet
import javax.servlet.ServletConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@ThreadSafe
class SynchronizedFactorizer(
    private var lastNumber: BigInteger,
    private var lastFactor: Array<BigInteger>,
) : Servlet {

    @Synchronized
    override fun service(req: ServletRequest?, res: ServletResponse?) {
        val i: BigInteger = extractFromRequest(req)
        if (i == lastNumber) {
            encodeIntoResponse(res)
        } else {
            var factors: Array<BigInteger> = factor(i)
            lastNumber = i
            lastFactor = factors
            encodeIntoResponse(res)
        }
    }

    override fun init(config: ServletConfig?) {
        TODO("Not yet implemented")
    }

    override fun getServletConfig(): ServletConfig {
        TODO("Not yet implemented")
    }



    override fun getServletInfo(): String {
        TODO("Not yet implemented")
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }
    private fun encodeIntoResponse(res: ServletResponse?) {
        TODO("Not yet implemented")
    }

    private fun factor(i: BigInteger): Array<BigInteger> {
        TODO("Not yet implemented")
    }

    private fun extractFromRequest(req: ServletRequest?): BigInteger {
        TODO("Not yet implemented")
    }
}