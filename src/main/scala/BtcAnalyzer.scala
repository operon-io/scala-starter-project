//
// Copyright (C) 2022 Operon.io
// MIT-license
//
package org.acme

import io.operon.runner.node.`type`._
import io.operon.runner.model.exception.OperonGenericException
import io.operon.runner.OperonFunction
import io.operon.runner.statement.Statement

class BtcAnalyzer extends OperonFunction {
    
    @throws(classOf[OperonGenericException])
    def execute(stmt: Statement, params: OperonValue): OperonValue = {
        println("Analyzing...")
        val num: NumberType = params.evaluate().asInstanceOf[NumberType]
        var result: StringType = null
        if (num.getDoubleValue() < 10000) {
            result = StringType.create(stmt, "BUY")
        }
        else {
            result = StringType.create(stmt, "HOLD")
        }
        return result
    }
}