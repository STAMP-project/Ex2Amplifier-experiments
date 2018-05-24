import sys
import json
import argparse

'''
same as the second version, but for a specific id of pr, given throught index parameters
'''
def run(project, flags, pr_id_to_run, onClusty=False, mustClone=True):
    err_out_redirection = "2>&1 | tee -a"
    print "classpath=`" + (
        "~/apache-maven-3.3.9/bin/" if onClusty else "") + "mvn dependency:build-classpath | grep /home`"

    base_cmd_jar = ("~/jdk1.8.0_121/bin/" if onClusty else "") + \
                   "java " + ("-Xms16G -Xmx32G" if onClusty else "") \
                   + " -cp target/Ex2Amplifier-experiments-0.0.1-SNAPSHOT.jar:${classpath} eu.stamp_project.Main "
    date = "may-2018"
    prefix_dataset = "dataset" + "/" + date + "/"
    suffix_json = ".json"
    path_to_json_project_file = prefix_dataset + project + suffix_json

    if onClusty:
        print "export MAVEN_HOME=~/apache-maven-3.3.9/"

    if mustClone:
        cmd_clone = base_cmd_jar + " --clone " + path_to_json_project_file + " --output " + prefix_dataset
        print cmd_clone, "\n"

    base_cmd_run = base_cmd_jar + \
                   " --verbose" + \
                   (" --maven-home ~/apache-maven-3.3.9/" if onClusty else "") + \
                   " --output " + prefix_dataset + \
                   " --run " + path_to_json_project_file + \
                   " --id"

    with open(path_to_json_project_file) as data_file:
        pull_request_data = json.load(data_file)["pullRequests"]

    for i in range(0, len(pull_request_data)):
        if pull_request_data[i]["id"] == pr_id_to_run:
            pr_data = pull_request_data[i]

    if pr_data == "":
        print "wrong pr id ({}) for {}".format(pr_id_to_run, project)
        return

    print "cd", prefix_dataset + project + "/" + \
                str(pr_data["id"]), "&&", \
        ("~/apache-maven-3.3.9/bin/" if onClusty else "") \
        + "mvn", "clean", "install", "-DskipTests", "&&", "cd", "../../../.."
    for flag in flags:
        output_file_log = "_".join(
            [str(project), str(pr_data["id"]), str("catg" if flag == "" else flag[2:])]) + ".log"
        print base_cmd_run, pr_data["id"], flag, err_out_redirection, output_file_log
        print "rm -rf target/dspot"


if __name__ == '__main__':

    flags = ["--amplifiers"]
    onClusty = True
    mustClone = True

    if len(sys.argv) < 2:
        print "usage python run-experiments <project> <pr_id> [onClusty] [mustClone] [amplifiers]"
    else:
        run(
            project=sys.argv[1],
            flags=flags,
            pr_id_to_run=int(sys.argv[-1]),
            onClusty=onClusty,
            mustClone=mustClone,
        )
