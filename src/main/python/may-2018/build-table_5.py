import sys
import json
import os
from os import listdir
from os.path import isfile, join, isdir
import csv
import subprocess


def build(projects):
    global nb_green
    global nb_yellow

    prefix_results = "results/may-2018"
    prefix_dataset = "dataset/may-2018"

    command_cloc = "cloc dataset/may-2018/{}/{} | grep Java | xargs | cut -d \" \" -f 5"

    lines = {
        'protostuff/201': '80306', 'mybatis-3/1084': '55962', 'javapoet/605': '8277', 'mybatis-3/926': '53751',
        'jsoup/988': '19140', 'javapoet/550': '7896', 'javapoet/608': '8277', 'protostuff/119': '78890',
        'jsoup/881': '16464', 'mybatis-3/1073': '55825', 'mybatis-3/1070': '55825', 'jsoup/903': '16784',
        'jsoup/901': '16784', 'jsoup/942': '17426', 'jsoup/1046': '19318', 'javapoet/526': '7536',
        'javapoet/524': '7523', 'mybatis-3/947': '53918', 'mybatis-3/895': '52937', 'javapoet/529': '7874',
        'javapoet/562': '8032', 'protostuff/180': '78417', 'javapoet/567': '8042', 'protostuff/184': '79526',
        'protostuff/185': '79442', 'javapoet/618': '8297', 'javapoet/469': '7377', 'protostuff/182': '79147',
        'mybatis-3/1149': '56401', 'jsoup/931': '17426', 'mybatis-3/1110': '56191', 'mybatis-3/1250': '56696',
        'mybatis-3/976': '53995', 'jsoup/918': '17454', 'jsoup/1038': '19243', 'jsoup/835': '16464'
    }

    url = {
        'javapoet': 'https://github.com/square/javapoet/pull/',
        'mybatis-3': 'https://github.com/mybatis/mybatis-3/pull/',
        'jsoup': 'https://github.com/jhy/jsoup/pull/',
        'protostuff': 'https://github.com/protostuff/protostuff/pull/',
    }

    times = {}
    times["A_ampl"] = []
    times["I_ampl"] = []

    for project in projects:

        path_to_project_result = prefix_results + "/" + project
        path_to_project_data = prefix_dataset + "/" + project + ".json"
        rows = []
        sucessfull_aampl = {}

        with open(path_to_project_data) as f:
            project_dataset_json = json.load(f)

        first = True

        for pr_data in project_dataset_json["pullRequests"]:
            pr_id = str(pr_data["id"])
            row = "&"
            # p = subprocess.Popen(command_cloc.format(project, pr_id), shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
            # for line in p.stdout.readlines():
            #    lines[str(project)+ "/" + str(pr_id)] = line
            # retval = p.wait()

            for mode in ["A_ampl", "I_ampl"]:
                pr_id_key = mode + pr_id
                display_mode = mode.replace("_", "\\_")
                datas = getData(path_to_project_result, pr_id, mode)
                if datas == "" or len(datas) < 4:
                    row += ("&" + str(pr_id) + "&" if mode == "A_ampl" else "") + "&&&"
                    continue
                nb, time_amplification, numberOfTestMethodToBeAmplifieds, numberOfAmplifiedTestMethods = datas
                if mode == "A_ampl":
                    sucessfull_aampl[pr_id] = [nb, numberOfAmplifiedTestMethods, time_amplification]
                    row += "\\href{"+url[project] + pr_id+"}{"+ str(pr_id) + "}" + \
                           "&" + str(numberOfTestMethodToBeAmplifieds) + "&" + \
                           lines[str(project) + "/" + str(pr_id)] + "&" + buildSanityTable(
                        prefix_results + "/" + project + "/" + pr_id, True)
                times[mode].append(time_amplification)
                time_amplification = convertTime(time_amplification)
                green, yellow = getColors(nb, numberOfAmplifiedTestMethods, mode, pr_id, sucessfull_aampl, 0, 1)
                isAmplValue = mode == "A_ampl" or not pr_id in sucessfull_aampl
                green_color = "009901"
                yellow_color = "FFFE65"
                row += "&{}\t&\t{}\t&\t{}".format(
                    ("\\cellcolor[HTML]{" + yellow_color + "}" if yellow else "") +
                    str(numberOfAmplifiedTestMethods),
                    ("\\cellcolor[HTML]{" + green_color + "}" if green else "") +
                    str(nb),
                    str(time_amplification),
                    )
            rows.append(row + "\\\\")

        print "\\hline\n\\multirow{" + str(len(rows)) + "}{*}{\\rotvertical{" + project + "}}"
        gray = False
        for row in rows:
            print row
    print nb_green, nb_yellow
    for mode in ["A_ampl", "I_ampl"]:
        print times[mode]
        times[mode].sort()
        print times[mode]
        print mode, convertTime(times[mode][len(times[mode]) / 2])


def convertTime(time_amplification):
    time_amplification = time_amplification / 1000
    if time_amplification > 60:
        return str(time_amplification // 60) + "m"
    else:
        return str(time_amplification) + "s"

def buildSanityTable(path, isSuccess):
    table = "&\n$\\begin{pmatrix}\n"
    with open(path + "/sanity.csv", 'rb') as csvfile:
        sanity = csv.reader(csvfile, delimiter=';', quotechar='|')
        sanityAsArray = [value for value in sanity]
        table += "$" + toCorrectMark(sanityAsArray[0][0]) + "$&$" + toCorrectMark(sanityAsArray[0][1]) + "$\\\\\n"
        table += "$" + toCorrectMark(sanityAsArray[1][1]) + "$&$" + toCorrectMark(sanityAsArray[1][1]) + "$\n"
        # table += "\\cmark" + "&" + ("\\xmark" if isSuccess else "\\cmark") + "\n"
    table += "\\end{pmatrix}$\n"

    return "$\\alpha$" if sanityAsArray[0][1] == "0" else "$\\beta$"

    return table


def toCorrectMark(value):
    return "\\cmark" if value == "0" else "\\xmark"


nb_green = 0
nb_yellow = 0


def getColors(nb, numberOfAmplifiedTestMethods, mode, pr_id, sucessfull_aampl, indexGreen, indexYellow):
    green_color = "009901"
    yellow_color = "FFFE65"
    global nb_green
    global nb_yellow
    green = False
    yellow = False
    if pr_id in sucessfull_aampl:
        if nb > 0:
            nb_green += 1
            green = True
        if numberOfAmplifiedTestMethods > 0:
            nb_yellow += 1
            yellow = True
    return green, yellow


def findJsonFilePathIn(directory):
    for file in os.listdir(directory):
        if file.endswith(".json"):
            return file
    return ""


def getData(path_to_project_result, pr_id, mode):
    path_result_for_mode = path_to_project_result + "/" + pr_id + "/" + mode
    nb = 0
    if not os.path.isdir(path_result_for_mode):
        return ""
    for file in listdir(path_result_for_mode):
        if isfile(join(path_result_for_mode, file)) and file.endswith("_change_report.txt"):
            fd = open(join(path_result_for_mode, file), 'r')
            lines = fd.read().split('\n')
            nb += int(lines[1].split(" ")[0])
    path_json_file = path_result_for_mode + "/" + pr_id + ".json"
    if not os.path.exists(path_json_file):
        path_json_file = path_result_for_mode + "/" + findJsonFilePathIn(path_result_for_mode + "/")
    if not os.path.exists(path_json_file) or not isfile(path_json_file):
        return -1, -1, -1, -1
    with open(path_json_file) as f:
        data = json.load(f)
    time_amplification = 0
    numberOfTestMethodToBeAmplified = 0
    numberOfAmplifiedTestMethods = 0
    for classTime in data["classTimes"]:
        time_amplification += int(classTime["timeInMs"])
        numberOfTestMethodToBeAmplified += int(classTime["numberOfTestMethodToBeAmplified"])
        numberOfAmplifiedTestMethods += int(classTime["numberOfAmplifiedTestMethods"])
    return nb, time_amplification, numberOfTestMethodToBeAmplified, numberOfAmplifiedTestMethods


if __name__ == '__main__':
    build(projects=["javapoet", "jsoup", "mybatis-3", "protostuff"])