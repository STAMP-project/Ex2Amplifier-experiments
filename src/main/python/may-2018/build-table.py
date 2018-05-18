import sys
import json
import os
from os import listdir
from os.path import isfile, join, isdir
import json


def build(projects):
    prefix_results = "results/may-2018"
    prefix_dataset = "dataset/may-2018"

    # print header of table
    for project in projects:
        path_to_project_result = prefix_results + "/" + project
        path_to_project_data = prefix_dataset + "/" + project + ".json"
        rows = {}
        sucessfull_aampl = {}

        with open(path_to_project_data) as f:
            project_dataset_json = json.load(f)

        for pr_data in project_dataset_json["pullRequests"]:
            for order in ["", "_modified"]:
                pr_id_key = project + "\\#" + str(pr_data["id"]) + str(order)
                pr_id = str(pr_data["id"]) + str(order)
                rows[pr_id_key] = []
                for mode in ["A_ampl", "CATG", "JBSE", "I_ampl"]:
                    display_mode = mode.replace("_", "\\_")
                    path_result_for_mode = path_to_project_result + "/" + pr_id + "/" + mode
                    nb = 0
                    if not os.path.isdir(path_result_for_mode):
                        continue
                    for file in listdir(path_result_for_mode):
                        if isfile(join(path_result_for_mode, file)) and file.endswith("_change_report.txt"):
                            fd = open(join(path_result_for_mode, file), 'r')
                            lines = fd.read().split('\n')
                            nb += int(lines[1].split(" ")[0])
                    path_json_file = path_result_for_mode + "/" + pr_id + ".json"
                    if not os.path.exists(path_json_file):
                        path_json_file = path_result_for_mode + "/protostuff-runtime.json"
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
                    # pr & id mod & nb amplification & nb amplified & nb successful amplified & time
                    if mode == "A_ampl":
                        sucessfull_aampl[pr_id_key] = nb
                    rows[pr_id_key].append(
                        "{}&{}&{}&{}&{}\\\\".format(
                            display_mode,
                            numberOfTestMethodToBeAmplified,
                            numberOfAmplifiedTestMethods,
                            (nb if mode == "A_ampl" else nb - sucessfull_aampl[pr_id_key]),
                            time_amplification
                        )
                    )
        gray = False
        for pr_id in sorted(rows):
            first = True
            display_id = pr_id if not pr_id.endswith("_modified") else pr_id.split("_")[0] + "*"
            #print ("\\rowcolor[HTML]{EFEFEF}" if gray else "") + "&\multirow{" + str(len(rows[pr_id])) + "}{*}{" + display_id + "}"
            for pr_row in rows[pr_id]:
                row_to_print = ""
                if gray:
                    row_to_print = "\\rowcolor[HTML]{EFEFEF}"
                if first:
                    print row_to_print + "\multirow{" + str(
                        len(rows[pr_id])) + "}{*}{" + display_id + "}&" + pr_row
                    first = False;
                else:
                    print row_to_print + "&" + pr_row
            if len(rows[pr_id]) > 0:
                print "\\hline"
            #gray = not gray


if __name__ == '__main__':
    build(projects=["javapoet", "mybatis-3", "protostuff", "jsoup"])
