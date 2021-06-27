package com.example.concurrent.safe

import com.example.concurrent.annotation.NotThreadSafe
import java.math.BigInteger
import java.util.concurrent.atomic.AtomicReference
import javax.servlet.Servlet
import javax.servlet.ServletConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@NotThreadSafe
class UnsafeCachingFactorizer(
    private val lastNumber: AtomicReference<BigInteger> = AtomicReference(),
    private val lastFactor: AtomicReference<Array<BigInteger>> = AtomicReference()
) : Servlet {

    override fun service(req: ServletRequest?, res: ServletResponse?) {
        val i: BigInteger = extractFromRequest(req)
        if (i == lastNumber.get()) {
            encodeIntoResponse(res, lastFactor.get())
        } else {
            var factors: Array<BigInteger> = factor(i)
            lastNumber.set(i)
            lastFactor.set(factors)
            encodeIntoResponse(res, factors)
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