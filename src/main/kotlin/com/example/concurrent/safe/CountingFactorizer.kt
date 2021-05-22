package com.example.concurrent.safe

import com.example.concurrent.annotation.ThreadSafe
import java.math.BigInteger
import java.util.concurrent.atomic.AtomicLong
import javax.servlet.Servlet
import javax.servlet.ServletConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@ThreadSafe
class CountingFactorizer(
    var count: AtomicLong = AtomicLong(0)
) : Servlet {

    fun count(): Long {
        return count.get()
    }

    override fun service(req: ServletRequest?, res: ServletResponse?) {
        val i: BigInteger = extractFromRequest(req)
        var factors: Array<BigInteger> = factor(i)
        count.incrementAndGet()
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