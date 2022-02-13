//
// Copyright (C) 2022 Operon.io
// MIT-license
//
import io.operon.runner.model.OperonConfigs
import io.operon.runner.OperonRunner
import io.operon.runner.node.`type`._

import org.acme.BtcAnalyzer

def query = """
	Select:
		-> http:{"url": "https://api.coindesk.com/v1/bpi/currentprice.json"}
		.body
		..EUR
		[1]
		.rate_float
		-> call:analyze:{"params": @}
"""

@main
def main: OperonValue = {
  val analyzer: BtcAnalyzer = new BtcAnalyzer()
  OperonRunner.registerFunction("analyze", analyzer)
  
  val configs: OperonConfigs = new OperonConfigs()
  configs.setOutputResult(false)
  val result: OperonValue = OperonRunner.doQuery(query, configs)
  println(result)
  result
}
