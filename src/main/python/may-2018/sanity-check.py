import json

def check(projects=["mybatis-3"]):
    date = "may-2018"
    prefix_dataset = "dataset" + "/" + date + "/"
    suffix_json = ".json"

    command = "./src/main/bash/" + date + "/sanity-check.sh"

    for project in projects:

        path_to_json_project_file = prefix_dataset + project + suffix_json
        with open(path_to_json_project_file) as data_file:
            pull_request_data = json.load(data_file)["pullRequests"]
        for pr in pull_request_data:
            if project == "protostuff":
                print command, project , pr["id"], "protostuff-parser" if pr["id"] == 119 else "protostuff-runtime"
            else:
                print command, project , pr["id"]


if __name__ == '__main__':
    check()
