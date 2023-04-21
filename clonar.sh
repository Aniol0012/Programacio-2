#!/bin/bash

common_help_panel() {
    echo -e "On: \n\t-p és per a fer el commit al github, sinó nomes se copia."
    echo -e "\tMISSATGE: Missatge per a incloure al commit, si no s'inclou un missatge 
        es printarà en numero de versió actual"
    echo "───────────────────────────────────────────────────────────────────────────"
}

help_panel() {
    echo "───────────────────────────────────────────────────────────────────────────"
    echo "Recorda que també pots fer servir: ./clonar.sh <-p <"MISSATGE">>"
    common_help_panel
}

help_panel2() {
    echo "───────────────────────────────────────────────────────────────────────────"
    echo "Recorda que l'us és: ./clonar.sh <-p <"MISSATGE">>"
    common_help_panel
}

help_panel3() {
    echo "───────────────────────────────────────────────────────────────────────────"
    echo "L'us és: ./clonar.sh <-p <"MISSATGE">>"
    common_help_panel
}

if [[ $1 == "--help" ]]; then
    help_panel3
    exit 0
fi

if [[ $# == 0 ]]; then
    help_panel # Si no es passen arguments
else
    help_panel2 # En cas que es passin arguments
fi

find . -name ".DS_Store" -type f -exec rm -f {} +

# Llexeix el valor actual del fitxer
current_version=$(echo $(git rev-list --count HEAD))

# Incrementa la versió en una unitat si es fa push, si no es manté igual
if [[ $1 == "-p" ]]; then
    new_version=$((current_version + 1))
else
    new_version=$((current_version))
fi

# Ens guardem tots els arguments a partir del 2n (inclós)
for arg in "${@:2}"; do
    commit=$commit" "$arg # Posem un espai entre arguments
done

if [[ $1 == "-p" ]]; then
    git add .
    if [[ $2 == "" ]]; then
        git commit -m "v$new_version"
    else
        git commit -m "v$new_version - $commit"
    fi
    git push
    exit
fi
