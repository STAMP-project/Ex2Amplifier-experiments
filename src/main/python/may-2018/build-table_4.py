import sys
import json
import os
from os import listdir
from os.path import isfile, join, isdir
import json
import csv


def build(projects):

    global nb_green
    global nb_yellow

    prefix_results = "results/may-2018"
    prefix_dataset = "dataset/may-2018"

    for project in projects:

        path_to_project_result = prefix_results + "/" + project
        path_to_project_data = prefix_dataset + "/" + project + ".json"
        rows = []
        sucessfull_aampl = {}

        with open(path_to_project_data) as f:
            project_dataset_json = json.load(f)

        modes = ["A_ampl", "CATG", "JBSE", "I_ampl"]
        display_modes = [mode.replace("_", "\\_") for mode in modes]

        first = True

        for pr_data in project_dataset_json["pullRequests"]:
            row = ""
            for mode in ["A_ampl", "CATG", "JBSE", "I_ampl"]:
                pr_id = str(pr_data["id"])
                pr_id_key = mode + pr_id
                display_mode = mode.replace("_", "\\_")
                datas = getDatas(path_to_project_result, pr_id, mode)
                if datas == "" or len(datas) < 4:
                    row += ("&"+str(pr_id)+"&" if mode == "A_ampl" else "" ) + "&&&"
                    continue
                nb, time_amplification, numberOfTestMethodToBeAmplifieds, numberOfAmplifiedTestMethods = datas
                if mode == "A_ampl":
                    sucessfull_aampl[pr_id] = [nb, numberOfAmplifiedTestMethods]
                    row += "&" + str(pr_id) + "&" + str(numberOfTestMethodToBeAmplifieds)

                isColored, color = getColors(nb, numberOfAmplifiedTestMethods, mode, pr_id, sucessfull_aampl, 0, 1)
                isAmplValue = mode == "A_ampl" or not pr_id in sucessfull_aampl
                if isColored:
                    row += "&{}\t&\t{}\t&\t{}".format(
                        "\\cellcolor[HTML]{" + color + "}" +
                        str(numberOfAmplifiedTestMethods if isAmplValue
                            else numberOfAmplifiedTestMethods - sucessfull_aampl[pr_id][1]),
                        "\\cellcolor[HTML]{" + color + "}" +
                        str(nb if isAmplValue
                            else nb - sucessfull_aampl[pr_id][0]),
                        "\\cellcolor[HTML]{" + color + "}" + str(time_amplification),
                    )
                else:
                    row += "&{}\t&\t{}\t&\t{}".format(
                        str(numberOfAmplifiedTestMethods if isAmplValue
                            else numberOfAmplifiedTestMethods - sucessfull_aampl[pr_id][1]),
                        str(nb if isAmplValue
                            else nb - sucessfull_aampl[pr_id][0]),
                        str(time_amplification),
                    )

            row += buildSanityTable(prefix_results + "/" + project +  "/"+ pr_id, color == "009901")
            if not first:
                row += "\\\\"
            first = not first
            rows.append(row)

        print "\\hline\n\\multirow{" + str(len(rows)) + "}{*}{\\rotvertical{" + project + "}}"
        gray = False
        for row in rows:
            print row

    print nb_green, nb_yellow

def buildSanityTable(path, isSuccess):
    table = "&\n$\\begin{pmatrix}\n"
    with open(path + "/sanity.csv", 'rb') as csvfile:
        sanity = csv.reader(csvfile, delimiter=';', quotechar='|')
        sanityAsArray = [value for value in sanity]
        table += "$" + toCorrectMark(sanityAsArray[0][0]) + "$&$" + toCorrectMark(sanityAsArray[0][1]) + "$\\\\\n"
        table += "$" + toCorrectMark(sanityAsArray[1][1]) + "$&$" + toCorrectMark(sanityAsArray[1][1]) + "$\n"
        #table += "\\cmark" + "&" + ("\\xmark" if isSuccess else "\\cmark") + "\n"
    table += "\\end{pmatrix}$\n"
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
    if pr_id in sucessfull_aampl:
        if ((nb > 0 and (mode == "A_ampl" or
                             not pr_id in sucessfull_aampl)) or nb - sucessfull_aampl[pr_id][indexGreen] > 0):
            nb_green += 1
            return True, green_color
        elif ((numberOfAmplifiedTestMethods > 0 and (mode == "A_ampl" or
                               not pr_id in sucessfull_aampl)) or numberOfAmplifiedTestMethods - sucessfull_aampl[pr_id][indexYellow] > 0):
            nb_yellow += 1
            return True, yellow_color
        else:
            return False, ""
    else:
        return False, ""


def getDatas(path_to_project_result, pr_id, mode):
    return getData(path_to_project_result, pr_id, mode)

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
    if not os.path.exists(path_json_file):
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
    time_amplification = time_amplification / 1000
    if time_amplification > 60:
        time_amplification = str(time_amplification // 60) + "m"
    else:
        time_amplification = str(time_amplification) + "s"
    return nb, time_amplification, numberOfTestMethodToBeAmplified, numberOfAmplifiedTestMethods


if __name__ == '__main__':
    build(projects=["javapoet", "jsoup", "protostuff"])
