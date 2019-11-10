package eu.mc80.java.fizzbuzz

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException

class CommandLineParserParametersExtractor : ParametersExtractor {
    override fun getEnd(vararg args: String): Int? {
        val endOption = Option.builder("e").required().longOpt("end").hasArg().build()

        val options = Options()
        options.addOption(endOption)

        val parser = DefaultParser()
        val cmd = try {
            parser.parse(options, args)
        } catch (_: ParseException) {
            return null
        }

        return try {
            Integer.parseInt(cmd.getOptionValue(endOption.opt))
        } catch (_: NumberFormatException) {
            null
        }
    }
}