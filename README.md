# Walnut 6
Walnut is an automated theorem prover for automatic words.

<ins>**Looking for older Walnut?**</ins> The previous version of Walnut (Walnut 5) is available [here](https://github.com/firetto/Walnut/tree/walnut5). 

<br>

To run Walnut, first run `build.sh` to build Walnut, then run the `walnut.sh` file.

Please read the `Manual.pdf` file in `Help Documentation/` to learn what Walnut is and how one would work with it. 

Use the `help;` command to view documentation for all available commands.

To run Walnut tests, run `build.sh` with the `-t` flag.

# Bug fixes

- Fixed a bug where the resulting Word Automaton after running the "combine" command was not totalized
- Fixed a bug where reversing an automaton that does not have a number system (i.e. uses {0, 1} as a number system) will throw an error
- Fixed a bug where whitespace and new lines in regular expressions could result in differing automata
- Fixed a bug where using the `combine` command on one automaton would not totalize the resulting Word Automaton and apply the valid representations


# Performance improvements
- Significant memory and time improvements; thanks to John Nicol for his contributions!
- Multiplication has been drastically sped up
