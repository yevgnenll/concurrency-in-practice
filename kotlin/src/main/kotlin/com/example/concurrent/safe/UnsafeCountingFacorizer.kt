package com.example.concurrent.safe

import java.math.BigInteger
import javax.servlet.Servlet
import javax.servlet.ServletConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class UnsafeCountingFacorizer(
    var count: Long = 0
) : Servlet {

    override fun service(req: ServletRequest?, res: ServletResponse?) {
        val i: BigInteger = extractFromRequest(req)
        var factors: Array<BigInteger> = factor(i)
        count++
        encodeIntoResponse(res, factors)
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

    private fun encodeIntoResponse(res: ServletResponse?, factors: Array<BigInteger>) {
        TODO("Not yet implemented")
    }

    private fun factor(i: BigInteger): Array<BigInteger> {
        TODO("Not yet implemented")
    }

    private fun extractFromRequest(req: ServletRequest?): BigInteger {
        TODO("Not yet implemented")
    }
}