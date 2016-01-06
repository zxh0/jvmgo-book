package main

func main() {
	cmd := parseCmd()

	if cmd.versionFlag {
		println("version 0.0.1")
	} else if cmd.helpFlag || cmd.class == "" {
		printUsage()
	} else {
		newJVM(cmd).start()
	}
}
