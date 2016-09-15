import org.gradle.api.*
import org.gradle.api.tasks.*
import groovy.json.*

class VersionNextPlugin implements Plugin<Project> {
	private Project pj
	private metaFile='projectMeta.json'
	
	void apply(Project project){
		pj=project
		JsonSlurper slurper = new JsonSlurper()
		def meta;
		def f = project.file(metaFile)
		if(f.exists()){
			meta = slurper.parseText(f.text)
		} else {
			meta = new HashMap<String, Object>()
			meta.putAt('major',0)
			meta.putAt('minor',1)
			meta.putAt('patch',0)
			write(meta)
		}
		

		project.task('currentVersion') << {
			println "${meta.major}.${meta.minor}.${meta.patch}"
		}
		
		project.task('patchNext',type:VersionNextTask) {
			_metaFile pj.file(metaFile)
			nextAction {
				meta.patch++
				return meta
			}
		}
		project.task('minorNext',type:VersionNextTask) {
			_metaFile pj.file(metaFile)
			nextAction {
				meta.minor++
				meta.patch=0
				return meta
			}
		}
		project.task('majorNext',type: VersionNextTask) {
			_metaFile pj.file(metaFile)
			nextAction  {
				meta.major++
				meta.minor=0
				meta.patch=0
				return meta
			}
		}
	}
}

class VersionNextTask extends DefaultTask {
	File _metaFile
	Closure nextAction
	
	@TaskAction
	def versionNext() {
		this.write()
	}
	void write(){
		JsonBuilder json = new JsonBuilder(nextAction())
		_metaFile.text = json.toPrettyString()
	}
}
