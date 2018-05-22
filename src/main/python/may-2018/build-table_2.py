import sys
import json
import os
from os import listdir
from os.path import isfile, join, isdir
import json


def build(projects):
    prefix_results = "results/may-2018"
    prefix_dataset = "dataset/may-2018"

    header = "\\begin{tabular}{l|lc|ccc||ccc}" \
             "Mode & " \
             "ID &\\rotvertical{\# Amplification} & " \
             "\\rotvertical{\# Amplified} & \\rotvertical{\# Success} & \\rotvertical{Times (min)} &" \
             " \\rotvertical{\# Amplified} & \\rotvertical{\# Success} & \\rotvertical{Times (min)} \\\\"
    footer = "\\end{tabular}"

    cpt = 0

    # print header of table
    for project in projects:
        print header

        path_to_project_result = prefix_results + "/" + project
        path_to_project_data = prefix_dataset + "/" + project + ".json"
        rows = []
        sucessfull_aampl = {}

        with open(path_to_project_data) as f:
            project_dataset_json = json.load(f)

        for pr_data in project_dataset_json["pullRequests"]:
            for mode in ["A_ampl", "CATG", "JBSE", "I_ampl"]:
                pr_id = str(pr_data["id"])
                pr_id_key = mode + pr_id
                display_mode = mode.replace("_", "\\_")
                datas = getDatas(path_to_project_result, pr_id, mode)
                if datas == "" or len(datas) < 8:
                    continue
                nb, time_amplification, numberOfTestMethodToBeAmplifieds, numberOfAmplifiedTestMethods, \
                nb_modified, time_amplification_modified, numberOfTestMethodToBeAmplifieds_modified, numberOfAmplifiedTestMethods_modified = datas
                # pr & id mod & nb amplification & nb amplified & nb successful amplified & time
                if mode == "A_ampl":
                    sucessfull_aampl[pr_id] = [nb, numberOfAmplifiedTestMethods,
                    nb_modified, numberOfAmplifiedTestMethods_modified]
                rows.append(
                    "{}&{}&{}&{}&{}&{}&{}&{}&{}\\\\".format(
                        display_mode,
                        pr_id,
                        numberOfTestMethodToBeAmplifieds,
                        (numberOfAmplifiedTestMethods if mode == "A_ampl" else numberOfAmplifiedTestMethods - sucessfull_aampl[pr_id][1]),
                        (nb if mode == "A_ampl" else nb - sucessfull_aampl[pr_id][0]),
                        time_amplification,
                        (numberOfAmplifiedTestMethods_modified if mode == "A_ampl" else numberOfAmplifiedTestMethods_modified - sucessfull_aampl[pr_id][3]),
                        (nb_modified if mode == "A_ampl" else nb_modified - sucessfull_aampl[pr_id][2]),
                        time_amplification_modified,
                    )
                )

        gray = False
        for row in sorted(rows):
            print row
        print footer
        print ("&" if cpt % 2 == 0 else "\\\\")
        cpt = cpt + 1


def getDatas(path_to_project_result, pr_id, mode):
    datas = getData(path_to_project_result, pr_id, mode), getData(path_to_project_result, pr_id + "_modified", mode)
    if datas == "":
        return ""
    returnValue = [element for tupl in datas for element in tupl]
    return [element for tupl in datas for element in tupl]

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
        time_amplification = time_amplification // 60
    return nb, time_amplification, numberOfTestMethodToBeAmplified, numberOfAmplifiedTestMethods


if __name__ == '__main__':
    build(projects=["javapoet", "mybatis-3","jsoup", "protostuff"])
