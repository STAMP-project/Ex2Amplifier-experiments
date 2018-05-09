import sys
import json
import os
from os import listdir
from os.path import isfile, join, isdir
import json

def build(projects):
    prefix_results = "results/may-2018"

    # print header of table

    for project in projects:
        path_to_project = prefix_results + "/" + project
        rows = {}
        for pr_id in sorted(listdir(path_to_project)):
            rows[pr_id] = []

            for mode in ["A_ampl", "CATG", "JBSE", "I_ampl"]:
                display_mode = mode.replace("_", "\\_")
                path_result_for_mode = path_to_project + "/" + pr_id + "/" + mode
                nb = 0
                if not os.path.isdir(path_result_for_mode):
                    continue
                for file in listdir(path_result_for_mode):
                    if isfile(join(path_result_for_mode, file)) and file.endswith("_change_report.txt"):
                        fd = open(join(path_result_for_mode, file), 'r')
                        lines = fd.read().split('\n')
                        nb += int(lines[1].split(" ")[0])
                path_json_file = path_result_for_mode + "/" + pr_id + ".json"
                with open(path_json_file) as f:
                    data = json.load(f)
                time_amplification = 0
                for classTime in data["classTimes"]:
                    time_amplification += int(classTime["timeInMs"])
                # pr & id mod & nb amplificaiton & nb amplified & nb successful amplified & time
                rows[pr_id].append("&{}&{}&{}&{}\\\\".format(display_mode, "XXX", nb, time_amplification))
        print "\multirow{"+ str(len(rows)) + "}{*}{"+ project +"}"
        gray = True
        for pr_id in rows:
            first = True
            display_id = pr_id if not pr_id.endswith("_modified") else pr_id.split("_")[0] + "*"
            print "&\multirow{"+ str(len(rows[pr_id])) + "}{*}{"+ display_id +"}"
            for pr_row in rows[pr_id]:
                print  ("\\rowcolor[HTML]{EFEFEF}" if gray else "" ) + ("" if first else "&") + pr_row
                first = False
            gray = not gray


if __name__ == '__main__':
    build(projects=["javapoet"])