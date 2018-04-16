# Ex2Amplifier-experiments

## Experiment january-2018

Amplification on pull request on github projects. We compare two kinds of amplifications:
*  [Ex2Amplification](https://github.com/STAMP-project/Ex2Amplifier.git) use symbolic execution to generate literals values to explore exhausitively the test data input space.
*  Classical Search-based amplication with [**DSpot**](http://STAMP-project/dspot.git) with the following options:
    * Input-amplifiers: StatementAdd, ReplacementAmplifier and AllLiteralAmplifiers.
    * 3 iterations.

In both case, we use the `ChangeDetectorSelector`, _i.e._
`--test-criterion ChangeDetectorSelector` and we select test classes to be
amplified according to a diff: _i.e._ `--test diff` options for **DSpot**.

## Install

#### Clone
```
git clone https://github.com/STAMP-project/Ex2Amplifier-experiments.git
```

#### Install

```
./src/main/bash/january-2018/install.sh
```

You will obtain `target/Ex2Amplifier-experiments-0.0.1-SNAPSHOT-jar-with-dependencies.jar`.

See command line options below.

#### Script experiments

**WARNING** the provided python script generate a bash script that runs on our own clusty. If you want to use it, you should modify some path, _e.g._ the path to maven home.

```
python src/main/python/january-2018/run-experiments.py <project> [onClusty] [mustClone] [amplifiers] [indexOfPR]
```

## Command line options

```
Usage: java -jar target/Ex2Amplifier-experiments-0.0.1-SNAPSHOT-jar-with-dependencies.jar
                          [-h|--help] [-v|--verbose] [-g|--get] [(-c|--clone) <clone>] [(-r|--run) <run>] [(-o|--output) <output>] [(-i|--id) <id>] [-j|--jbse] [--aampl] [-a|--amplifiers] [--reverse] [--depth <depth>] [--count <count>] [--maven-home <maven-home>]

  [-h|--help]
        shows this help

  [-v|--verbose]
        enable verbose mode.

  [-g|--get]
        [TASK] get all metadata about openned pull request of specified projects
        in dataset/projects.
        Each project should be on one line, and in this format:
        <owner>/<repository-name>/.
        the output is a json file contained in result/.

  [(-c|--clone) <clone>]
        [TASK] clone all pull request datas (base and head) of the specified
        json file.

  [(-r|--run) <run>]
        [TASK] run the Ex2Amplifier, using the ChangeDetectorSelector.
        You must specify options of DSpot after the flag separated with $.

  [(-o|--output) <output>]
        [optional] Specify the output path of the selected task. (default:
        target/ex2amplifier_out/ (default: target/ex2amplifier_out/)

  [(-i|--id) <id>]
        [optional] specify a pr ID. If no value is given, it will process all
        the ids (default: -1)

  [-j|--jbse]
        enable de JBSE mode of the Ex2Amplifier

  [--aampl]
        [optional] will use only A-amplification.

  [-a|--amplifiers]
        [optional] will use "classical" amplifiers, i.e. StatementAdd and
        Literal amplifiers

  [--reverse]
        [optional] will amplify modified version, and see if amplified tests
        fail on the base

  [--depth <depth>]
        (default: 8)

  [--count <count>]
        (default: 1500)

  [--maven-home <maven-home>]
        [Optional] specify a custom path for maven.

```