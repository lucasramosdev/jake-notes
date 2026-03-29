import meilisearch
import json
from dotenv import load_dotenv
import os

load_dotenv()

client = meilisearch.Client(os.getenv('MEILI_HOST'), os.getenv('MEILI_MASTERKEY'))

json_file = open('notes.json', encoding='utf-8')
notes = json.load(json_file)
client.index('notes').add_documents(notes)